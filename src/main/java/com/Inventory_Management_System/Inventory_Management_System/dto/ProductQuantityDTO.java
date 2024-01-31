package com.Inventory_Management_System.Inventory_Management_System.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ProductQuantityDTO {
    private String productId;
    private String quantity;
}
