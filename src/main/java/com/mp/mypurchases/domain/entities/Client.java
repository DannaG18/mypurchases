package com.mp.mypurchases.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table (name = "clients")
@Data
@Builder
@AllArgsConstructor 
@NoArgsConstructor
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(max = 40, message = "Name cannot exceed 40 characters")
    @Column(nullable = false, length = 40, name = "name")
    private String name;

    @NotNull(message = "Lastname cannot be null")
    @Size(max = 100, message = "Last name cannot exceed 100 characters")
    @Column(nullable = false, length = 100, name = "last_name")
    private String lastName;

    @NotNull(message = "Telephone cannot be null")
    @Size(min = 10, max = 15, message = "Telephone must be between 10 and 15 characters")
    @Column(nullable = false, unique=true, length = 15, name = "telephone")
    private String telephone;  

    @NotNull(message = "Address cannot be null")
    @Size(max = 80, message = "Address cannot exceed 80 characters")
    @Column(nullable = false, length = 80, name = "address")
    private String address;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    @Column(nullable = false, unique=true, length = 100, name = "email")
    private String email;

}
