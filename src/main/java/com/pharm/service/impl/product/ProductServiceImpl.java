package com.pharm.service.impl.product;

import com.pharm.model.Product;
import com.pharm.repository.product.ProductRepository;
import com.pharm.service.interfaces.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.pharm.util.CommonConstant.DELETE;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product create(Product product) {
        product.setStatus("A");
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product delete(Product product) {
        if(product!=null && product.getId()!=null){
            product.setStatus(DELETE);
        }

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product update(Product product) {
        if (product.getId() != null) {
            Product persisted = findById(product.getId());
            if (persisted == null) {
                return null;
            }
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
