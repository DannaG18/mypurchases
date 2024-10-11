package com.mp.mypurchases.infrastructure.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import com.mp.mypurchases.application.services.PurchaseService;
import com.mp.mypurchases.domain.entities.Purchase;


@RestController
@RequestMapping("/api/purchases")
@CrossOrigin(origins = "http://localhost:5174") 
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public List<Purchase> findAll() {
        return purchaseService.findAll();
    }

    @PostMapping("/{id}")
    public Optional<Purchase> findById(@PathVariable Long id) {
        return purchaseService.findById(id);
    }

    @PostMapping
    public Purchase save(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }

    @PutMapping("/{id}")
    public Purchase update(@PathVariable Long id, @RequestBody Purchase purchase) {
        return purchaseService.update(id, purchase); 
    }

    @DeleteMapping("/{id}")
    public void deletePurchases(@PathVariable Long id) {
        purchaseService.delete(id);
    }
}
