package com.mp.mypurchases.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mp.mypurchases.domain.entities.Product;
import com.mp.mypurchases.infrastructure.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly=true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<Product> dbProduct = repository.findById(id);
        if (dbProduct.isPresent()) {
            Product newProduct = dbProduct.get();
            newProduct.setName(product.getName());
            newProduct.setCategory(product.getCategory());
            newProduct.setBarcode(product.getBarcode());
            newProduct.setPrice(product.getPrice());
            newProduct.setStock(product.getStock());
            newProduct.setStatus(product.getStatus());

            return repository.save(newProduct);
        }
        return null;
    }

    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> product = repository.findById(id);
        product.ifPresent(target -> {
            repository.delete(target);
        });
        return product;
    }
}
