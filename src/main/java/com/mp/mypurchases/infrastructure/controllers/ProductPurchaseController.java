package com.mp.mypurchases.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mp.mypurchases.application.services.ProductPurchaseService;
import com.mp.mypurchases.domain.entities.ProductPurchase;
import com.mp.mypurchases.domain.entities.ProductPurchaseId;

@RestController
@RequestMapping("/api/productpurchases")
@CrossOrigin(origins = "http://localhost:5174") 
public class ProductPurchaseController {
    
    @Autowired
    private ProductPurchaseService productPurchaseService;

    @GetMapping
    public List<ProductPurchase> findAll() {
        return productPurchaseService.findAll();
    }

    @PostMapping("/{id}")
    public Optional<ProductPurchase> findById(@PathVariable ProductPurchaseId id) {
        return productPurchaseService.findById(id);
    }

    @PostMapping
    public ProductPurchase save(@RequestBody ProductPurchase productPurchase) {
        return productPurchaseService.save(productPurchase);
    }

    @PutMapping("/{id}")
    public ProductPurchase update(@PathVariable ProductPurchaseId id, @RequestBody ProductPurchase productPurchase) {
        return productPurchaseService.update(id, productPurchase); 
    }

    @DeleteMapping("/{id}")
    public void deleteProductPurchase(@PathVariable ProductPurchaseId id) {
        productPurchaseService.delete(id);
    }
}
