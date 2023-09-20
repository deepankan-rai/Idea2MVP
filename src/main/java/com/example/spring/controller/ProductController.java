package com.example.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Product;
import com.example.spring.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody  Product product){
		Product prd=productServiceImpl.addProduct(product);
		return new ResponseEntity<Product>(prd,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Optional<Product>> findById(@PathVariable Long prodId){
		Optional<Product> prdi=productServiceImpl.getById(prodId);
		return new ResponseEntity<Optional<Product>>(prdi,HttpStatus.OK);
		
	}
	
	@GetMapping("/allStd")
	public ResponseEntity<List<Product>> getAllPrd(){
		List<Product> prds=productServiceImpl.getAllProduct();
		return new ResponseEntity<List<Product>>(prds,HttpStatus.OK);
	}
	
	

}
