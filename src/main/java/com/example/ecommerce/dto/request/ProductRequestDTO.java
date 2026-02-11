package com.example.ecommerce.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @Min(value = 0, message = "Stock cannot be negative")
    private int stockQuantity;

    @NotNull(message = "Category ID is required")
    private Long categoryId;
}
