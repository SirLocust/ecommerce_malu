package com.malu.ecommerce.repository;

import com.malu.ecommerce.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
