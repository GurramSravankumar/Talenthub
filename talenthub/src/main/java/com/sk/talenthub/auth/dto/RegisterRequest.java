package com.sk.talenthub.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(
        max = 254,
        message = "Email must not exceed 254 characters"
    )
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(
        min = 8,
        max = 100,
        message = "Password must be between 8 and 100 characters"
    )
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$",
        message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;
}