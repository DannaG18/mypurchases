package com.mp.mypurchases.application.services;

import java.util.Optional;
import java.util.List;

import com.mp.mypurchases.domain.entities.Purchase;

public interface PurchaseService {
    List<Purchase> findAll();
    Optional<Purchase> findById(Long id);
    Purchase save(Purchase purchase);
    Purchase update(Long id, Purchase purchase);
    Optional<Purchase> delete(Long id);
}
