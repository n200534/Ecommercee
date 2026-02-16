package com.example.ecommerce.controller;

import com.example.ecommerce.dto.response.OrderResponseDTO;
import com.example.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> placeOrder(

    ) {
        return ResponseEntity.ok(orderService.placeOrder());
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getOrders(

    ) {
        return ResponseEntity.ok(orderService.getUserOrders());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{orderId}/status")
    public ResponseEntity<OrderResponseDTO> updateStatus(
            @PathVariable Long orderId,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(
                orderService.updateOrderStatus(orderId, status)
        );
    }

}

