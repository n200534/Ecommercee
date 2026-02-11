package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.AddToCartRequestDTO;
import com.example.ecommerce.dto.response.CartResponseDTO;
import com.example.ecommerce.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartResponseDTO> addToCart(
            @PathVariable Long userId,
            @Valid @RequestBody AddToCartRequestDTO request
    ) {
        return ResponseEntity.ok(cartService.addToCart(userId, request));
    }

    @GetMapping
    public ResponseEntity<CartResponseDTO> getCart(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> remove(
            @PathVariable Long userId,
            @PathVariable Long productId
    ) {
        cartService.removeFromCart(userId, productId);
        return ResponseEntity.noContent().build();
    }
}

