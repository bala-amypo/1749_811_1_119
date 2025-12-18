package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserPortfolioServiceImpl
        implements UserPortfolioService {

    private final UserPortfolioRepository repository;

    public UserPortfolioServiceImpl(
            UserPortfolioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserPortfolio save(UserPortfolio portfolio) {
        return repository.save(portfolio);
    }

    @Override
    public List<UserPortfolio> getAll() {
        return repository.findAll();
    }

    @Override
    public UserPortfolio getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
