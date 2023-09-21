package com.example.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	Optional<User> findOneByUsernameAndPassword(String username,String passsword);
	
	User findByUsername(String username);

}
