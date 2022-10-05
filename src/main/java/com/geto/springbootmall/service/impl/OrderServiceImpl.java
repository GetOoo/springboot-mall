package com.geto.springbootmall.service.impl;

import com.geto.springbootmall.dao.OrderDao;
import com.geto.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
}
