package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.AddToCartRequestDTO;
import com.example.ecommerce.dto.response.CartResponseDTO;

public interface CartService {

    CartResponseDTO addToCart(AddToCartRequestDTO request);

    CartResponseDTO getCart();

    void removeFromCart(Long productId);
}
