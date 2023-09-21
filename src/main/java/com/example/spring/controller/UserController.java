package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.configuration.LoginResponse;
import com.example.spring.dto.LoginDto;
import com.example.spring.dto.UserDto;
import com.example.spring.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserDto userDto) {
		String id= userService.addUser(userDto);
		return id;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?>loginuser(@RequestBody LoginDto loginDto){
		LoginResponse loginResponse=userService.loginUser(loginDto);
		return ResponseEntity.ok(loginResponse);
	}
	

}
