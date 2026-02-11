package com.example.ecommerce.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItemResponseDTO {

    private Long productId;
    private String productName;
    private int quantity;
    private double price;
}

