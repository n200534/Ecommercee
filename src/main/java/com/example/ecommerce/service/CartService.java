package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.AddToCartRequestDTO;
import com.example.ecommerce.dto.response.CartResponseDTO;

public interface CartService {

    CartResponseDTO addToCart(Long userId, AddToCartRequestDTO request);

    CartResponseDTO getCart(Long userId);

    void removeFromCart(Long userId, Long productId);
}
