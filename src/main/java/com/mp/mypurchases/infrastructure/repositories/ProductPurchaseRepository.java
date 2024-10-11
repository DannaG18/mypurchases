package com.mp.mypurchases.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mp.mypurchases.domain.entities.ProductPurchase;
import com.mp.mypurchases.domain.entities.ProductPurchaseId;

public interface ProductPurchaseRepository extends CrudRepository<ProductPurchase, ProductPurchaseId> {
    
}
