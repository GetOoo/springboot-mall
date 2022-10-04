package com.geto.springbootmall.service;

import com.geto.springbootmall.dto.ProductRequest;
import com.geto.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
