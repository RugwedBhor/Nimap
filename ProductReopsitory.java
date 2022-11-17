package com.categories.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.categories.demo.model.Product;

public interface ProductReopsitory extends JpaRepository<Product, Integer>{

}
