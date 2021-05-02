package com.malu.ecommerce.controller;

import java.util.List;

import com.malu.ecommerce.model.Product;
import com.malu.ecommerce.service.ProductsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/products")
@AllArgsConstructor
public class ProductController {

  private final ProductsService productsService;

  @GetMapping
  public ResponseEntity<List<Product>> listProducts() {
    List<Product> products = productsService.listAllProduct();
    if (products.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(products);
  }

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Product productCreate = productsService.createProduct(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
  }
}
