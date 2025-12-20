package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService portfolioService;

    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping("/{userId}")
    public UserPortfolio createPortfolio(@PathVariable Long userId, @RequestBody UserPortfolio portfolio) {
        return portfolioService.createPortfolio(portfolio, userId);
    }

    @GetMapping("/{id}")
    public UserPortfolio getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserPortfolio> getPortfoliosByUser(@PathVariable Long userId) {
        return portfolioService.getPortfoliosByUser(userId);
    }
}
