package com.malu.ecommerce.service;

import java.time.Instant;
import java.util.List;

import com.malu.ecommerce.model.Category;
import com.malu.ecommerce.model.Product;
import com.malu.ecommerce.repository.ProductRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ProductServiceImpl implements ProductsService {

  private final ProductRepository productRepository;

  @Override
  public List<Product> listAllProduct() {
    return productRepository.findAll();

  }

  @Override
  public Product getProduct(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public Product createProduct(Product product) {
    product.setStatus("CREATED");
    product.setCreateAT(Instant.now());
    return productRepository.save(product);
  }

  @Override
  public Product updateProduct(Product product) {
    Product productDb = getProduct(product.getId());
    if (productDb == null) {
      return null;
    }
    productDb.setName(product.getName());
    productDb.setDescription(product.getDescription());
    productDb.setCategory(product.getCategory());
    productDb.setPrice(product.getPrice());

    return productRepository.save(productDb);
  }

  @Override
  public Product deleteProduct(Long id) {
    Product productDb = getProduct(id);
    if (productDb == null) {
      return null;
    }
    productDb.setStatus("DELETED");
    return productRepository.save(productDb);
  }

  @Override
  public List<Product> findByCategoria(Category category) {
    return productRepository.findByCategory(category);
  }

  @Override
  public Product updateStock(Long id, Double quantity) {
    Product productDb = getProduct(id);
    if (productDb == null) {
      return null;
    }
    Double stock = productDb.getStock() + quantity;
    productDb.setStock(stock);
    return productRepository.save(productDb);
  }

}
