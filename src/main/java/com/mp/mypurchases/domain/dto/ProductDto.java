package com.mp.mypurchases.domain.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
    private String barcode;
    private BigDecimal price;
    private int stock;
    private Boolean status;

}
