package com.example.spring.model;

public class ApiResponse {
	
	private String message;
	private boolean success;
	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	

}
