package com.geto.springbootmall.service.impl;

import com.geto.springbootmall.dao.ProductDao;
import com.geto.springbootmall.dto.ProductRequest;
import com.geto.springbootmall.model.Product;
import com.geto.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
