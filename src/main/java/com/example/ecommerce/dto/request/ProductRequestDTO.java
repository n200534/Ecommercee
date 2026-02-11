package com.example.ecommerce.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Long categoryId;
}
