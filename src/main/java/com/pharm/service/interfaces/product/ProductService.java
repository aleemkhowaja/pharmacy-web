package com.pharm.service.interfaces.product;

import com.pharm.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product create(Product product) ;
    Product delete(Product product);
    Product update(Product product);
    Product findById(Long id);
}
