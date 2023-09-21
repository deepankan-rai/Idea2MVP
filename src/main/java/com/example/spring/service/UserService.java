package com.example.spring.service;

import com.example.spring.configuration.LoginResponse;
import com.example.spring.dto.LoginDto;
import com.example.spring.dto.UserDto;
public interface UserService {

	String addUser(UserDto userDto);
	LoginResponse loginUser(LoginDto loginDto); 
}
