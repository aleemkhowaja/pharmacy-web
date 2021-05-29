package com.pharm.service.impl.product;

import com.pharm.model.Product;
import com.pharm.repository.product.ProductRepository;
import com.pharm.service.interfaces.product.ProductService;
import com.pharm.util.CommonConstant;
import com.pharm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Product> findAll(int pageNumber, int pageSize, String sortOrder, String sortBy, Product filter) {

        String validationErrors = PageUtil.validatePaginationParams(pageNumber, pageSize, sortOrder, sortBy);
        if((isNotBlank(validationErrors))) {
            throw new IllegalArgumentException(validationErrors);
        }

        final Long pharmaceuticalForm = filter.getPharmaceuticalForm() == null ? null :filter.getPharmaceuticalForm().getId();
        final Long dci = filter.getDci() == null ? null :filter.getDci().getId();


        Page<Product> products = productRepository.filter(filter.getName(),filter.getBarCode(), filter.getBarCode2(), filter.getLaboratory(),
                filter.getSubRange(), filter.getProductTable(), pharmaceuticalForm, filter.getPpv(),dci,PageUtil.returnPageable(pageNumber, pageSize, sortOrder, sortBy));

        if(products.hasContent())
        {
            final Long size = productRepository.count(filter.getName(),filter.getBarCode(), filter.getBarCode2(), filter.getLaboratory(),
                    filter.getSubRange(), filter.getProductTable(), pharmaceuticalForm, filter.getPpv(), dci);
            System.out.println("size::"+size);
            products.getContent().get(0).setCount(size);
        }
        return products.getContent();
    }

    @Override
    @Transactional
    public Product create(Product product) {
        product.setStatus(CommonConstant.ACTIVE);
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product delete(Product product) {
        if(product!=null && product.getId()!=null){
            Product deleted = findById(product.getId());
            if (deleted != null) {
                deleted.setStatus(CommonConstant.DELETE);
                return productRepository.save(deleted);
            }
        }
        return null;
    }

    @Override
    @Transactional
    public Product update(Product product) {
        if (product.getId() != null) {
            Product persisted = findById(product.getId());
            if (persisted == null) {
                return null;
            }
            product.setStatus(CommonConstant.ACTIVE);
            Product updated = productRepository.save(product);
            return updated;
        }
        return null;
    }

    @Override
    @Transactional
    public Product findById(Long id) {
        Optional<Product> optionalUser = productRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }
}
