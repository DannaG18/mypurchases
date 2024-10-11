package com.mp.mypurchases.application.services;

import java.util.List;
import java.util.Optional;
import com.mp.mypurchases.domain.entities.ProductPurchase;
import com.mp.mypurchases.domain.entities.ProductPurchaseId;


public interface ProductPurchaseService {
    List<ProductPurchase> findAll();
    Optional<ProductPurchase> findById(ProductPurchaseId id);
    ProductPurchase save(ProductPurchase productPurchase);
    ProductPurchase update(ProductPurchaseId id, ProductPurchase productPurchase);
    Optional<ProductPurchase> delete(ProductPurchaseId id);
}
