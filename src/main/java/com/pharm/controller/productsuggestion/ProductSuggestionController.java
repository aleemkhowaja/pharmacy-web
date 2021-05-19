package com.pharm.controller.productsuggestion;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.ProductSuggestion;
import com.pharm.service.interfaces.productsuggestion.ProductSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSuggestionController implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private ProductSuggestionService productSuggestionService;

    public List<ProductSuggestion> getAllProductSuggestions(
            final int pageNumber,
            final int pageSize,
            final String sortOrder,
            final String sortBy,
            final ProductSuggestion filter
    ) { return productSuggestionService.findAll(pageNumber, pageSize, sortOrder, sortBy, filter); }
    public ProductSuggestion getProductSuggestionById(Long id) { return productSuggestionService.findById(id); }
    public ProductSuggestion createProductSuggestion(ProductSuggestion productSuggestion) {
        productSuggestion.setStatus("A");
        return productSuggestionService.create(productSuggestion);
    }
    public ProductSuggestion updateProductSuggestion(long id, ProductSuggestion productSuggestion) {
        productSuggestion.setId(id);
        return productSuggestionService.update(productSuggestion);
    }
    public ProductSuggestion deleteProductSuggestion(long id) {
        ProductSuggestion productSuggestion = new ProductSuggestion();
        productSuggestion.setId(id);
        return productSuggestionService.delete(productSuggestion); }

}
