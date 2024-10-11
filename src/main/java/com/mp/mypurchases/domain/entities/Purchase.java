package com.mp.mypurchases.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;
import lombok.*;

@Entity
@Table (name = "purchases")
@Data
@Builder
@AllArgsConstructor 
@NoArgsConstructor
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "client_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "date")
    private Date date;

    @NotNull(message = "Payment method cannot be null")
    @Size(min = 1, max = 1, message = "Payment method must be a single character")
    @Column(nullable = false, length = 1, name = "payment_method")
    private Character paymentMethod;

    @NotNull(message = "Comment cannot be null")
    @Size(max = 300, message = "Comment cannot exceed 300 characters")
    @Column(nullable = false, length = 300, name = "comment")
    private String comment;

    @NotNull(message = "Status cannot be null")
    @Size(min = 1, max = 1, message = "Status must be a single character")
    @Column(nullable = false, length = 1, name = "status")
    private Character status;
}
