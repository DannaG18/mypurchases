package com.mp.mypurchases.application.services;

import java.util.List;
import java.util.Optional;

import com.mp.mypurchases.domain.entities.Product;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Product update(Long id, Product product);
    Optional<Product> delete(Long id);
}
