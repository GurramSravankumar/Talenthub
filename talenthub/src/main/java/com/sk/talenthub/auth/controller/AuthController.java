package com.sk.talenthub.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.talenthub.auth.dto.LoginRequest;
import com.sk.talenthub.auth.dto.RegisterRequest;
import com.sk.talenthub.auth.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(
	        @Valid @RequestBody RegisterRequest request) {
	    try {
	        String message = authService.register(request);

	        return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body(message);

	    } catch (IllegalStateException e) {

	        return ResponseEntity
	                .status(HttpStatus.CONFLICT)
	                .body(e.getMessage());
	    }
	}
	
	@PostMapping("/login")
    public ResponseEntity<String> login(
            @Valid @RequestBody LoginRequest request) {

        try {

            String token = authService.login(request);

            return ResponseEntity.ok(token);
        } catch (IllegalStateException e) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }
    }

}
