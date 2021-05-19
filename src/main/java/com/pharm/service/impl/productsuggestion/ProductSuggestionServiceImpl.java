package com.pharm.service.impl.productsuggestion;

import com.pharm.model.ProductSuggestion;
import com.pharm.repository.productsuggestion.ProductSuggestionRepository;
import com.pharm.service.interfaces.productsuggestion.ProductSuggestionService;
import com.pharm.util.CommonConstant;
import com.pharm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.pharm.util.CommonConstant.DELETE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class ProductSuggestionServiceImpl implements ProductSuggestionService {

    @Autowired
    private ProductSuggestionRepository productSuggestionRepository;

    @Override
    @Transactional
    public List<ProductSuggestion> findAll(int pageNumber, int pageSize, String sortOrder, String sortBy, ProductSuggestion filter) {

        String validationErrors = PageUtil.validatePaginationParams(pageNumber, pageSize, sortOrder, sortBy);
        if((isNotBlank(validationErrors))) {
            throw new IllegalArgumentException(validationErrors);
        }

        Page<ProductSuggestion> productSuggestions = productSuggestionRepository.filter(filter.getLastName(),filter.getBarCode(), filter.getBarCode2(), filter.getLaboratory(),
                filter.getSubRange(), filter.getProductTable(),PageUtil.returnPageable(pageNumber, pageSize, sortOrder, sortBy));
        if(productSuggestions.hasContent())
        {
            final Long size = productSuggestionRepository.count(filter.getLastName(),filter.getBarCode(), filter.getBarCode2(), filter.getLaboratory(),
                    filter.getSubRange(), filter.getProductTable());
            System.out.println("size::"+size);
            productSuggestions.getContent().get(0).setCount(size);
        }
        return productSuggestions.getContent();

    }

    @Override
    @Transactional
    public ProductSuggestion create(ProductSuggestion productSuggestion) {
        productSuggestion.setStatus(CommonConstant.ACTIVE);
        return productSuggestionRepository.save(productSuggestion);
    }

    @Override
    @Transactional
    public ProductSuggestion delete(ProductSuggestion productSuggestion) {
        if (productSuggestion != null && productSuggestion.getId() != null) {
            ProductSuggestion deleted = findById(productSuggestion.getId());
            if (deleted != null) {
                deleted.setStatus(CommonConstant.DELETE);
                return productSuggestionRepository.save(deleted);
            }
        }
        return null;
    }

    @Override
    @Transactional
    public ProductSuggestion update(ProductSuggestion productSuggestion) {
        if (productSuggestion.getId() != null) {
            ProductSuggestion persisted = findById(productSuggestion.getId());
            if (persisted == null) {
                return null;
            }
            productSuggestion.setStatus(CommonConstant.ACTIVE);
            ProductSuggestion updated = productSuggestionRepository.save(productSuggestion);
            return updated;
        }
        return null;
    }

    @Override
    @Transactional
    public ProductSuggestion findById(Long id) {
        Optional<ProductSuggestion> optionalUser = productSuggestionRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }
}
