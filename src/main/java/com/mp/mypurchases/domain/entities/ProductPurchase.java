package com.mp.mypurchases.domain.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table (name = "product_purchases")
@Data
public class ProductPurchase {
    
    @EmbeddedId
    private ProductPurchaseId id;  // Llave compuesta

    @Column(nullable = false, name = "quantity")
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @Column(nullable = false, name = "total")
    @Positive(message = "Total must be positive")
    private BigDecimal total;

    @Column(nullable = false, length = 20, columnDefinition="tinyint(1)",  name = "status")
    @NotNull(message = "Product status cannot be null")
    private Boolean status;
}
