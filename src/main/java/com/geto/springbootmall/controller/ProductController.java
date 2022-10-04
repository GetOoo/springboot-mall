package com.geto.springbootmall.controller;

import com.geto.springbootmall.dto.ProductRequest;
import com.geto.springbootmall.model.Product;
import com.geto.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        return (product != null)
                ? ResponseEntity.status(200).body(product)
                : ResponseEntity.status(404).build();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(
            @RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(201).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Integer productId,
            @RequestBody @Valid ProductRequest productRequest) {
        // check product exist
        if (productService.getProductById(productId) == null) {
            return ResponseEntity.status(404).build();
        }
        // update product
        productService.updateProduct(productId, productRequest);

        Product updateProduct = productService.getProductById(productId);

        return ResponseEntity.status(200).body(updateProduct);
    }
}
