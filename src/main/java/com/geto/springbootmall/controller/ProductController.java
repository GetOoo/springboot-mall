package com.geto.springbootmall.controller;

import com.geto.springbootmall.constant.ProductCategory;
import com.geto.springbootmall.dto.ProductQueryParams;
import com.geto.springbootmall.dto.ProductRequest;
import com.geto.springbootmall.model.Product;
import com.geto.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search
            ) {
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);

        List<Product> productList = productService.getProducts(productQueryParams);
        return ResponseEntity.status(200).body(productList);
    }


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

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
