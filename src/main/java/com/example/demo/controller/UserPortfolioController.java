package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
public class UserPortfolioController {
    private final UserService userService;

public UserPortfolioController(UserService userService) {
    this.userService = userService;
}

    @PostMapping
    public UserPortfolio create(@RequestBody UserPortfolio portfolio) {
        return repository.save(portfolio);
    }

    @GetMapping
    public List<UserPortfolio> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public UserPortfolio getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
