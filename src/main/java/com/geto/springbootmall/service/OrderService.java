package com.geto.springbootmall.service;

import com.geto.springbootmall.dto.CreateOrderRequest;
import com.geto.springbootmall.dto.OrderQueryParams;
import com.geto.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
