package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/detail")
	public UserDetails getUserDetail(Authentication auth) {
		return (UserDetails) auth.getPrincipal();
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<String> updateUserDetail(@PathVariable Long userId) {
		userService.updateUser(userId);
		return new ResponseEntity<String>("Updated Successfullly",HttpStatus.OK);
	}
	

}
