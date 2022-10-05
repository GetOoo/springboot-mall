package com.geto.springbootmall.service;

import com.geto.springbootmall.constant.ProductCategory;
import com.geto.springbootmall.dto.ProductQueryParams;
import com.geto.springbootmall.dto.ProductRequest;
import com.geto.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
