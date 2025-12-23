package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository repo;

    public UserPortfolioServiceImpl(UserPortfolioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        portfolio.setCreatedAt(
                new Timestamp(System.currentTimeMillis()).toLocalDateTime()
        );
        return repo.save(portfolio);
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        portfolio.setId(id);
        return repo.save(portfolio);
    }

    @Override
    public void deletePortfolio(Long id) {
        repo.deleteById(id);
    }
}
