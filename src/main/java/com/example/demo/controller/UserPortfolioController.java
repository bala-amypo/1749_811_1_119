package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService portfolioService;

    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping
    public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(portfolioService.createPortfolio(portfolio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPortfolio> getPortfolio(@PathVariable Long id) {
        return ResponseEntity.ok(portfolioService.getPortfolioById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPortfolio>> getPortfoliosByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(portfolioService.getPortfoliosByUser(userId));
    }
}
