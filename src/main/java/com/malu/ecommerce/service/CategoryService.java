package com.malu.ecommerce.service;

import java.util.List;

import com.malu.ecommerce.model.Category;

public interface CategoryService {

  public List<Category> getCategory();

  public Category createCategory(Category category);
}
