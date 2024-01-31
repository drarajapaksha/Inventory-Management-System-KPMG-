package com.Inventory_Management_System.Inventory_Management_System.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="products")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 5,nullable = false)
    private Long productId;
    @Column(length = 150,nullable = false)
    private String productName;
    @Column(length = 10,nullable = false)
    private int quantity;
    @Column(length = 10,nullable = false)
    private double price;

}
