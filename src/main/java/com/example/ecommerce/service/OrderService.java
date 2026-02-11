package com.example.ecommerce.service;

import com.example.ecommerce.dto.response.OrderResponseDTO;

import java.util.List;

public interface OrderService {

    OrderResponseDTO placeOrder(Long userId);

    List<OrderResponseDTO> getUserOrders(Long userId);
}

