package com.mp.mypurchases.application.services;

import java.util.List;
import java.util.Optional;

import com.mp.mypurchases.domain.entities.Category;


public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
    Category update(Long id, Category category);
    Optional<Category> delete(Long id);
}
