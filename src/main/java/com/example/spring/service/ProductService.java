package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import com.example.spring.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Optional<Product> getById(Long prodId);

}
