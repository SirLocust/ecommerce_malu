package com.malu.ecommerce.service;

import java.util.List;

import com.malu.ecommerce.model.Category;
import com.malu.ecommerce.model.Product;

public interface ProductsService {
  public List<Product> listAllProduct();

  public Product getProduct(Long id);

  public Product createProduct(Product product);

  public Product updateProduct(Product product);

  public Product deleteProduct(Long id);

  public List<Product> findByCategoria(Category category);

  public Product updateStock(Long id, Double quantity);
}
