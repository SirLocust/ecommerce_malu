package com.malu.ecommerce.repository;

import java.util.List;

import com.malu.ecommerce.model.Category;
import com.malu.ecommerce.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  public List<Product> findByCategory(Category category);
}
