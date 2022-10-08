package com.geto.springbootmall.controller;

import com.geto.springbootmall.dto.CreateOrderRequest;
import com.geto.springbootmall.model.Order;
import com.geto.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @GetMapping("/users/{userId}/orders")
//    public ResponseEntity<Order> getOrders(
//            @PathVariable Integer userId,
//            @RequestParam(required = false) Integer orderId
//    ) {
//
//    }

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest) {
        Integer orderId = orderService.createOrder(userId, createOrderRequest);

        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.status(201).body(order);
    }
}
