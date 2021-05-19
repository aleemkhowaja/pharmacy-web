package com.pharm.controller.product;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Product;
import com.pharm.service.interfaces.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductController implements GraphQLMutationResolver, GraphQLQueryResolver{

    @Autowired
    private ProductService productService;

    public List<Product> getAllProducts(
            final int pageNumber,
            final int pageSize,
            final String sortOrder,
            final String sortBy,
            final Product filter
    ) { return productService.findAll(pageNumber, pageSize, sortOrder, sortBy, filter); }
    public Product getProductById(Long id) { return productService.findById(id); }
    public Product createProduct(Product product) {
        product.setStatus("A");
        return productService.create(product);
    }
    public Product updateProduct(long id, Product product) {
        product.setId(id);
        return productService.update(product);
    }
    public Product deleteProduct(long id) {
        Product product = new Product();
        product.setId(id);
        return productService.delete(product); }

}
