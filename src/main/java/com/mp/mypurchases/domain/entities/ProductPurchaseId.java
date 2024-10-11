package com.mp.mypurchases.domain.entities;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductPurchaseId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "purchase_id", nullable = false)
    private Purchase purchaseId;


}
    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     ProductPurchaseId that = (ProductPurchaseId) o;
    //     return Objects.equals(productId, that.productId) &&
    //         Objects.equals(purchaseId, that.purchaseId);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(productId, purchaseId);
    // }