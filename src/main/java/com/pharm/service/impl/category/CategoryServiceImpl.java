package com.pharm.service.impl.category;

import com.pharm.model.Category;
import com.pharm.repository.category.CategoryRepository;
import com.pharm.service.interfaces.category.CategoryService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }
        return null;
    }

    @Override
    public Category create(Category category) {
        category.setStatus(CommonConstant.ACTIVE);
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        if (category.getId()!=null){
            Category persisted = findById(category.getId());
            if(persisted==null){
                return null;
            }
            category.setStatus(CommonConstant.ACTIVE);
            return categoryRepository.save(category);
        }
        return category;
    }

    @Override
    public Category delete(Category category) {
        if (category.getId()!=null && category!=null){
            Category deleted = findById(category.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return categoryRepository.save(deleted);
            }

        }
        return null;
    }
}
