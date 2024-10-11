package com.mp.mypurchases.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mp.mypurchases.domain.entities.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    
}
