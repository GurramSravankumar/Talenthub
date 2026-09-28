package com.sk.talenthub.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginRequest {
	
	
	    @NotBlank(message = "Email is mandatory")
	    @Email(message = "Email should be valid")
	    private String email;

	    @NotBlank
	    private String password;

}
