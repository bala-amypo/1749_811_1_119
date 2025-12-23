package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User found = userService.findByEmail(user.getEmail());
        if (found == null) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(found.getEmail(), found.getRole(), found.getId());
        return ResponseEntity.ok(token);
    }
}
