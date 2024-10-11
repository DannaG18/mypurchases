package com.mp.mypurchases.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mp.mypurchases.domain.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    
}
