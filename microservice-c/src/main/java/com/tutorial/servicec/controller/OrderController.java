package com.tutorial.servicec.controller;

import com.tutorial.servicec.model.Order;
import com.tutorial.servicec.repository.OrderRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Order Management", description = "APIs for managing orders")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    @Operation(summary = "Get all orders", description = "Retrieve a list of all orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID", description = "Retrieve a specific order by its ID")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Create a new order", description = "Create a new order with userId, productId, and quantity")
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}
