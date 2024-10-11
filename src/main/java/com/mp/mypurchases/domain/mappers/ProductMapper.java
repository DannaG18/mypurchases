package com.mp.mypurchases.domain.mappers;

import com.mp.mypurchases.domain.dto.ProductDto;
import com.mp.mypurchases.domain.entities.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getCategory() != null ? product.getCategory().getId() : null, // Mapea el categoryId
            product.getCategory() != null ? product.getCategory().getDescription() : "No Category", // Mapea el categoryName
            product.getBarcode(),
            product.getPrice(),
            product.getStock(),
            product.getStatus()
        );
    }
}

