package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository repo;

    public UserPortfolioServiceImpl(UserPortfolioRepository repo) {
        this.repo = repo;
    }

    public UserPortfolio savePortfolio(UserPortfolio portfolio) {
        return repo.save(portfolio);
    }

    public List<UserPortfolio> getAllPortfolios() {
        return repo.findAll();
    }
}
