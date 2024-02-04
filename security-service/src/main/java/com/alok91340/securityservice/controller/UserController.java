package com.alok91340.securityservice.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alok91340.securityservice.dto.LoginDto;
import com.alok91340.securityservice.dto.RegisterDto;
import com.alok91340.securityservice.dto.UserDto;
import com.alok91340.securityservice.service.UserService;
import com.alok91340.securityservice.utils.JwtAuthResponse;
import com.alok91340.securityservice.utils.JwtTokenProvider;

@RestController
@RequestMapping("auth/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	    
	    
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	
	
	
	@PostMapping("register")
	public ResponseEntity<UserDto> registerUser(@RequestBody RegisterDto registerDto){
		UserDto registeredUser = this.userService.registerUser(registerDto);
		return ResponseEntity.ok(registeredUser);
	}
	@GetMapping("token")
	public ResponseEntity<JwtAuthResponse> getJwtToken(@RequestBody LoginDto loginDto){
		
		
		try {
			authenticate(loginDto.getUsername(),

			        loginDto.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginDto.getUsername());

        final String token = tokenProvider.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthResponse(token));
	}
	
	
	private void authenticate(String username, String password) throws

	Exception {

	    Objects.requireNonNull(username);

	    Objects.requireNonNull(password);

	    try {

	        authenticationManager.authenticate(new

	        UsernamePasswordAuthenticationToken(username, password));
	        System.out.println("hello");
	    } catch (DisabledException e) {

	        throw new Exception("USER_DISABLED", e);

	    } catch (BadCredentialsException e) {

	        throw new Exception("INVALID_CREDENTIALS", e);
	    }
	  }
}
