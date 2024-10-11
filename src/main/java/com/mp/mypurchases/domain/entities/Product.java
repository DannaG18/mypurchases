package com.mp.mypurchases.domain.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length = 45, name="name")
    @NotNull(message = "Product name cannot be null")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "category_id" )
    private Category category;

    @Column(nullable=false, unique=true, length = 150, name="barcode")
    @NotNull(message = "Barcode cannot be null")
    @Size(max = 150, message = "Barcode must not exceed 150 characters")
    private String barcode;

    @Column(nullable=false, precision = 16, scale = 2)
    @NotNull(message = "Price cannot be null")
    @Digits(integer = 14, fraction = 2, message = "Price format is invalid")
    private BigDecimal price;

    @Column(nullable = false)
    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;

    @Column(nullable=false, columnDefinition="tinyint(1)", name="status")
    @NotNull(message = "Product status cannot be null")
    private Boolean status;

}
