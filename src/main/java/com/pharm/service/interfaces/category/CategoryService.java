package com.pharm.service.interfaces.category;

import com.pharm.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findById(Long id);
    Category create(Category category);
    Category update(Category category);
    Category delete(Category category);
}
