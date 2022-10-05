package com.geto.springbootmall.service;

import com.geto.springbootmall.constant.ProductCategory;
import com.geto.springbootmall.dto.ProductRequest;
import com.geto.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
