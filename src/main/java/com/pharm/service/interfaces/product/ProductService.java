package com.pharm.service.interfaces.product;

import com.pharm.model.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product) ;
    Product delete(Product product);
    Product update(Product product);
    Product findById(Long id);

    List<Product> findAll(int pageNumber, int pageSize, String sortOrder, String sortBy, Product filter);
}
