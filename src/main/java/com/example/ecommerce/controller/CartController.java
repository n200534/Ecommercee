package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.AddToCartRequestDTO;
import com.example.ecommerce.dto.response.CartResponseDTO;
import com.example.ecommerce.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartResponseDTO> addToCart(
            @Valid @RequestBody AddToCartRequestDTO request
    ) {
        return ResponseEntity.ok(cartService.addToCart(request));
    }

    @GetMapping
    public ResponseEntity<CartResponseDTO> getCart() {
        return ResponseEntity.ok(cartService.getCart());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> remove(
            @PathVariable Long productId
    ) {
        cartService.removeFromCart(productId);
        return ResponseEntity.noContent().build();
    }
}

