package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AuthController {

    private final UserService service;

    public AuthController(
            UserService service) {
        this.service = service;
    }

    @PostMapping
    public User create(
            @RequestBody User user) {
        return service.save(user);
    }

    @GetMapping
    public List<User> list() {
        return service.getAll();
    }
}
