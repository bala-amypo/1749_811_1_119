package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AuthController {
   private final Userrepository;

    public RiskAnalysisResultServiceImpl(
            RiskAnalysisResultRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping
    public List<User> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
