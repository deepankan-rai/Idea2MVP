package com.example.spring.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring.configuration.LoginResponse;
import com.example.spring.dto.LoginDto;
import com.example.spring.dto.UserDto;
import com.example.spring.model.User;
import com.example.spring.repository.UserRepo;
import com.example.spring.service.UserService;

@Service
public class UserImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		User user=new User(userDto.getUserId(),userDto.getUsername(),this.passwordEncoder.encode(userDto.getPassword()));
		
		userRepo.save(user);
		return user.getUsername();
	}

	@Override
	public LoginResponse loginUser(LoginDto loginDto) {
		// TODO Auto-generated method stub
		String msg="";
		User user1=userRepo.findByUsername(loginDto.getUsername());
		if(user1!=null) {
			String password=loginDto.getPassword();
			String encodedPassword=user1.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight) {
				Optional<User>usr=userRepo.findOneByUsernameAndPassword(loginDto.getUsername(), encodedPassword);
				if(usr.isPresent()) {
					return new LoginResponse("Login Success", true);
				}else {
					return new LoginResponse("Login Failed", false);
				}
				
			}else {
				return new LoginResponse("password not match", false);
			}
		}else {
			return new LoginResponse("username Not exits", false);
		}
	
	}

	@Override
	public String updateUser(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> usr=userRepo.findById(userId);
		if(usr.isPresent()) {
			User user=new User();
			userRepo.save(user);
			return "Updated successfully";
		}else {
			return null;
		}

	}

}
