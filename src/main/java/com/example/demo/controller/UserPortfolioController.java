package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService service;

    public UserPortfolioController(UserPortfolioService service) {
        this.service = service;
    }

    @PostMapping
    public UserPortfolio create(@RequestBody UserPortfolio portfolio) {
        return service.savePortfolio(portfolio);
    }

    @GetMapping
    public List<UserPortfolio> list() {
        return service.getAllPortfolios();
    }
}
