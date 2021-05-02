package com.malu.ecommerce.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private Double stock;
  private Double price;
  private String status;
  // @Temporal(TemporalType.TIMESTAMP)
  private Instant createAT;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", insertable = true, updatable = true)
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  private Category category;
}
