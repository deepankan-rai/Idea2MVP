package com.example.spring.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.model.Product;
import com.example.spring.repository.ProductRepo;
import com.example.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		Product prod= productRepo.save(product);
		
		return prod;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product>prdList=productRepo.findAll();
		return prdList;
	}

	@Override
	public Optional<Product> getById(Long prodId) {
		// TODO Auto-generated method stub
		
		Optional<Product> prd=productRepo.findById(prodId);
		if(prd.isPresent()) {
			return prd;
		}else {
		
		return Optional.empty();
		}
	}
	

}
