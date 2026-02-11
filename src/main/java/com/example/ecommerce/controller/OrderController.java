package com.example.ecommerce.controller;

import com.example.ecommerce.dto.response.OrderResponseDTO;
import com.example.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> placeOrder(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(orderService.placeOrder(userId));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getOrders(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(orderService.getUserOrders(userId));
    }
}

