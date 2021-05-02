package com.malu.ecommerce.dto;

import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductsResponse {
  private ResponseEntity response;
}
