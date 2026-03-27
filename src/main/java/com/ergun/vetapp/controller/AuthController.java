package com.ergun.vetapp.controller;

import com.ergun.vetapp.entity.User;
import com.ergun.vetapp.repository.UserRepository;
import com.ergun.vetapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        return authService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }
}