package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.AuthResponse;
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
/
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        User saved = userService.saveUser(user);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        User user = userService.findByEmail(request.getEmail());
        if (user == null) {
            throw new RuntimeException("Not found");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole(),
                user.getId()
        );

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
