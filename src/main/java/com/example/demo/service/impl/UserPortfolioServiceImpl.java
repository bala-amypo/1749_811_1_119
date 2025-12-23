package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final List<UserPortfolio> portfolios = new ArrayList<>();

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        portfolios.add(portfolio);
        return portfolio;
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return portfolios.stream().findFirst().orElse(null);
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return portfolios;
    }
}
