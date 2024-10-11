package com.mp.mypurchases.infrastructure.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mp.mypurchases.application.services.ProductService;
import com.mp.mypurchases.domain.dto.ProductDto;
import com.mp.mypurchases.domain.entities.Product;
import com.mp.mypurchases.domain.mappers.ProductMapper;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:5173") 
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productService.findAll();
        // Utilizamos el método estático toDto del ProductMapper para convertir las entidades a DTOs
        List<ProductDto> productDtos = products.stream()
                                               .map(ProductMapper::toDto)
                                               .collect(Collectors.toList());
        return ResponseEntity.ok(productDtos);
    }

    @PostMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product); 
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
