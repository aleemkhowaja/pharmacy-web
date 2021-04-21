package com.pharm.service.impl.productsuggestion;

import com.pharm.model.ProductSuggestion;
import com.pharm.repository.productsuggestion.ProductSuggestionRepository;
import com.pharm.service.interfaces.productsuggestion.ProductSuggestionService;
import com.samcm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSuggestionServiceImpl implements ProductSuggestionService {

    @Autowired
    private ProductSuggestionRepository productSuggestionRepository;

    @Override
    @Transactional
    public List<ProductSuggestion> findAll() {
        return productSuggestionRepository.findAll();
    }

    @Override
    @Transactional
    public ProductSuggestion create(ProductSuggestion productSuggestion) {
        productSuggestion.setStatus("A");
        return productSuggestionRepository.save(productSuggestion);
    }

    @Override
    @Transactional
    public ProductSuggestion delete(ProductSuggestion productSuggestion) {
        if(productSuggestion!=null && productSuggestion.getId()!=null){
            productSuggestion.setStatus(CommonConstant.DELETE);
        }

        return productSuggestionRepository.save(productSuggestion);
    }

    @Override
    @Transactional
    public ProductSuggestion update(ProductSuggestion productSuggestion) {
        if (productSuggestion.getId() != null) {
            ProductSuggestion persisted = findById(productSuggestion.getId());
            if (persisted == null) {
                return null;
            }
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
