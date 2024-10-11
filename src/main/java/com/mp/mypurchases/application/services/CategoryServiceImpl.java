package com.mp.mypurchases.application.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.mypurchases.domain.entities.Category;
import com.mp.mypurchases.infrastructure.repositories.CategoryRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly=true)
    @Override
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        Optional<Category> dbCategory = repository.findById(id);
        if (dbCategory.isPresent()) {
            Category newCategory = dbCategory.get();
            newCategory.setDescription(category.getDescription());
            newCategory.setStatus(category.getStatus());
            return repository.save(newCategory);
        }
        return null;
    }

    @Override
    public Optional<Category> delete(Long id) {
        Optional<Category> category = repository.findById(id);
        category.ifPresent(target -> {
            repository.delete(target);
        });
        return category;
    }
}
