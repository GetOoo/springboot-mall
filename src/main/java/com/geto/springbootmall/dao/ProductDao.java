package com.geto.springbootmall.dao;

import com.geto.springbootmall.dto.ProductRequest;
import com.geto.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
