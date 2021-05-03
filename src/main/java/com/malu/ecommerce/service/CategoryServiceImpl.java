package com.malu.ecommerce.service;

import java.util.List;

import com.malu.ecommerce.model.Category;
import com.malu.ecommerce.repository.CategoryRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Override
  public List<Category> getAllCategories() {

    return categoryRepository.findAll();
  }

  @Override
  public Category createCategory(Category category) {
    return categoryRepository.save(category);
  }

}
