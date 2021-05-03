package com.malu.ecommerce.controller;

import java.util.List;

import com.malu.ecommerce.model.Category;
import com.malu.ecommerce.service.CategoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/api/categories")

@AllArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<Category>> getCategories() {
    List<Category> categoriesDb = categoryService.getAllCategories();
    if (categoriesDb.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(categoriesDb);
  }

  @PostMapping
  public ResponseEntity<Category> createCategory(@RequestBody Category category) {
    Category categoryCreated = categoryService.createCategory(category);
    return ResponseEntity.status(HttpStatus.CREATED).body(categoryCreated);
  }

}
