package com.mp.mypurchases.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length=45, nullable=false, name="description")
    @NotNull(message = "Category description cannot be null")
    private String description;

    @Column(nullable=false, columnDefinition="tinyint(1)", name="status")
    @NotNull(message = "Category status cannot be null")
    private Boolean status;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}