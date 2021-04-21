package com.pharm.service.interfaces.productsuggestion;


import com.pharm.model.ProductSuggestion;

import java.util.List;

public interface ProductSuggestionService {

    List<ProductSuggestion> findAll();
    ProductSuggestion create(ProductSuggestion productSuggestion) ;
    ProductSuggestion delete(ProductSuggestion productSuggestion);
    ProductSuggestion update(ProductSuggestion productSuggestions);
    ProductSuggestion findById(Long id);
}
