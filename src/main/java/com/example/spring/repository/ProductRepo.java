package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
