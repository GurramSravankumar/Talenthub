package com.sk.talenthub.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class TestController {

    @GetMapping("/me")
    public String getCurrentUser(Authentication authentication) {
        return authentication.getName();
    }
}
