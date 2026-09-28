package com.sk.talenthub.auth.service;

import com.sk.talenthub.auth.dto.LoginRequest;
import com.sk.talenthub.auth.dto.RegisterRequest;


public interface AuthService {
	
	String register(RegisterRequest request);
	
	String login(LoginRequest request);
	

}
