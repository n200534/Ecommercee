package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.ProductRequestDTO;
import com.example.ecommerce.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO request);

    ProductResponseDTO getProductById(Long id);

    List<ProductResponseDTO> getAllProducts();

    List<ProductResponseDTO> getProductsByCategory(Long categoryId);

    void deleteProduct(Long id);
}

