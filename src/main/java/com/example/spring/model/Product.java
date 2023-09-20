package com.example.spring.model;

import java.math.BigDecimal;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	  @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long prodId;
	    private String name;
	    private String description;
	    private BigDecimal price;
	    
	    
	    public Product() {
			// TODO Auto-generated constructor stub
		}
	    
	    


		public Long getProdId() {
			return prodId;
		}




		public void setProdId(Long prodId) {
			this.prodId = prodId;
		}




		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}


}
