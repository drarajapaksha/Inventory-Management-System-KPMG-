package com.Inventory_Management_System.Inventory_Management_System.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

   // private int productId;

    private String productName;

    private  int quantity;

    private double price;
}
