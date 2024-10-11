package com.mp.mypurchases.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mp.mypurchases.domain.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    
}
