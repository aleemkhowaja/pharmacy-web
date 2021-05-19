package com.pharm.controller.category;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Category;
import com.pharm.service.interfaces.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CategoryService categoryService;

    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }
    public Category getCategoryById(Long id){
        return categoryService.findById(id);
    }
    public Category createCategory(Category category){
        return categoryService.create(category);
    }
    public Category updateCategory(Category category){ return categoryService.update(category); }
    public Category deleteCategory(Long id){
        Category category= new Category();
        category.setId(id);
        return categoryService.delete(category);
    }
}
