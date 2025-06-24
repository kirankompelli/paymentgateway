package com.fintech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.dto.AuthResponse;
import com.fintech.dto.RegisterUserRequest;
import com.fintech.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	@Autowired
	private AuthService authservice;
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterUserRequest request){
		       AuthResponse response=  authservice.register(request);
		       return ResponseEntity.ok(response);
	}
    
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestParam String email,@RequestParam String password){
		AuthResponse response=    authservice.login(email, password);
		               return ResponseEntity.ok(response);     
	}
	
	
	@GetMapping("/get")
	public String getMessage() {
		return "i am authorized";
	}
	
}
