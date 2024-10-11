package com.mp.mypurchases.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mp.mypurchases.domain.entities.ProductPurchase;
import com.mp.mypurchases.domain.entities.ProductPurchaseId;  // Asegúrate de importar ProductPurchaseId
import com.mp.mypurchases.infrastructure.repositories.ProductPurchaseRepository;

@Service
public class ProductPurchaseServiceImpl implements ProductPurchaseService {

    @Autowired
    private ProductPurchaseRepository repository;

    @Transactional(readOnly=true)
    @Override
    public List<ProductPurchase> findAll() {
        return (List<ProductPurchase>) repository.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public Optional<ProductPurchase> findById(ProductPurchaseId id) {  // Cambia Long a ProductPurchaseId
        return repository.findById(id);
    }

    @Transactional
    @Override
    public ProductPurchase save(ProductPurchase productPurchase) {
        return repository.save(productPurchase);
    }

    @Override
    public ProductPurchase update(ProductPurchaseId id, ProductPurchase productPurchase) {  // Cambia Long a ProductPurchaseId
        Optional<ProductPurchase> dbProductPurchase = repository.findById(id);
        if (dbProductPurchase.isPresent()) {
            ProductPurchase newProductPurchase = dbProductPurchase.get();
            newProductPurchase.setQuantity(productPurchase.getQuantity());
            newProductPurchase.setTotal(productPurchase.getTotal());
            newProductPurchase.setStatus(productPurchase.getStatus());
            return repository.save(newProductPurchase);
        }
        return null;
    }

    @Override
    public Optional<ProductPurchase> delete(ProductPurchaseId id) {  // Cambia Long a ProductPurchaseId
        Optional<ProductPurchase> productPurchase = repository.findById(id);
        productPurchase.ifPresent(target -> {
            repository.delete(target);
        });
        return productPurchase;
    }
}

