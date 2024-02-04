package com.alok91340.securityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alok91340.securityservice.dto.RegisterDto;
import com.alok91340.securityservice.dto.UserDto;
import com.alok91340.securityservice.entities.User;
import com.alok91340.securityservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}

	
	public UserDto registerUser(RegisterDto registerDto) {
		
		User user = new User();
		
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		
		String hashedPassword = bCryptPasswordEncoder.encode(registerDto.getPassword());
		user.setPassword(hashedPassword);
		
		User savedUser = this.userRepository.save(user);
		
		UserDto userDto= new UserDto();
		userDto.setId(savedUser.getId());
		userDto.setUsername(savedUser.getUsername());
		userDto.setEmail(savedUser.getEmail());
		
		return userDto;
		
	}

}
