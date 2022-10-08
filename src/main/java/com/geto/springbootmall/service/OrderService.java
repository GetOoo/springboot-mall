package com.geto.springbootmall.service;

import com.geto.springbootmall.dto.CreateOrderRequest;
import com.geto.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
