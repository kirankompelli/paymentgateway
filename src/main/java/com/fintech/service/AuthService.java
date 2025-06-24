package com.fintech.service;

import com.fintech.dto.AuthResponse;
import com.fintech.dto.RegisterUserRequest;

public interface AuthService {
	
	
	AuthResponse register(RegisterUserRequest register);

	AuthResponse login(String email,String password);
}
