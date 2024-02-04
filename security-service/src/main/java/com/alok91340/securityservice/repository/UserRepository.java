package com.alok91340.securityservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alok91340.securityservice.entities.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	
	Optional<User> findByUsername(String username);

}
