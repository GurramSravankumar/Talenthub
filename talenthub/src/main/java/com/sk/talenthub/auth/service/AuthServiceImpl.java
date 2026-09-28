package com.sk.talenthub.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sk.talenthub.auth.dto.LoginRequest;
import com.sk.talenthub.auth.dto.RegisterRequest;
import com.sk.talenthub.user.entity.User;
import com.sk.talenthub.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	

	@Override
	public String register(RegisterRequest request) {
		
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new IllegalStateException("Email already taken");
		}
		
		User user = User.builder()
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role("CANDIDATE")
				.enabled(true)
				.build();
		
	   		userRepository.save(user);
				
		return "User registered successfully";
	}
	
	@Override
	public String login(LoginRequest request) {

	    authenticationManager.authenticate(
	            UsernamePasswordAuthenticationToken.unauthenticated(
	                    request.getEmail(),
	                    request.getPassword()
	            )
	    );

	    User user = userRepository.findByEmail(request.getEmail())
	            .orElseThrow(() -> new IllegalStateException("User not found"));

	    return jwtService.generateToken(user);
	}


}
