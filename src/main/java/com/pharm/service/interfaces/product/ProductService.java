package com.pharm.service.interfaces.product;

import com.pharm.model.Product;

import java.util.List;

public interface ProductService {

    Product create(final Product product) ;

    Product delete(final Product product);

    Product update(final Product product);

    public Product updateSomeProperties(final Product product);

    Product findById(final Long id);

    List<Product> findAll(final int pageNumber, final int pageSize, final String sortOrder, final String sortBy, final Product filter);
}
