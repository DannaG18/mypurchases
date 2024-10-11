package com.mp.mypurchases.application.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mp.mypurchases.domain.entities.Purchase;
import com.mp.mypurchases.infrastructure.repositories.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    
    @Autowired
    private PurchaseRepository repository;

    @Transactional(readOnly=true)
    @Override
    public List<Purchase> findAll() {
        return (List<Purchase>) repository.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public Optional<Purchase> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Purchase save(Purchase purchase) {
        return repository.save(purchase);
    }

    @Override
    public Purchase update(Long id, Purchase purchase) {
        Optional<Purchase> dbPurchase = repository.findById(id);
        if (dbPurchase.isPresent()) {
            Purchase newPurchase = dbPurchase.get();
            newPurchase.setClient(purchase.getClient());
            newPurchase.setDate(purchase.getDate());
            newPurchase.setPaymentMethod(purchase.getPaymentMethod());
            newPurchase.setComment(purchase.getComment());
            newPurchase.setStatus(purchase.getStatus());

            return repository.save(newPurchase);
        }
        return null;
    }

    @Override
    public Optional<Purchase> delete(Long id) {
        Optional<Purchase> purchase = repository.findById(id);
        purchase.ifPresent(target -> {
            repository.delete(target);
        });
        return purchase;
    }
}
