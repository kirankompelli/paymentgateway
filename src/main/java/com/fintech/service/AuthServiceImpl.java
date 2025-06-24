package com.fintech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fintech.dto.AuthResponse;
import com.fintech.dto.RegisterUserRequest;
import com.fintech.entity.User;
import com.fintech.repository.UserRepository;
import com.fintech.util.JwtUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	 private  PasswordEncoder passwordEncoder;

	  @Autowired
	 private  JwtUtils jwtUtils ;
	
	
	public AuthResponse register(RegisterUserRequest register) {
		                 if(userRepository.existsByEmail(register.getEmail())) {
		                	 throw new RuntimeException("Email already exists");
		                	 
		                 }
		            		 
		                User user=User.builder()
		                		.name(register.getName())
		                		.email(register.getEmail())
		                		.password(passwordEncoder.encode(register.getPassword()))
		                		.isActive(true)
		                		.isVerified(false)
		                		.role("User")
		                		.build();
		              User savedUser=  userRepository.save(user);
		               String token=jwtUtils.generateToken(savedUser);
		            		   
		            		     
		            		   
		return new AuthResponse(user.getEmail(),token,"User registerd sucessfully");
	}

	
	public AuthResponse login(String email, String password) {
		User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
		if(!passwordEncoder.matches(password, user.getPassword())){
			throw new RuntimeException("Invalid credentials");
			}
		String token = jwtUtils.generateToken(user);

        return new AuthResponse(user.getEmail(), token, "Login successful");
	
	}

}
