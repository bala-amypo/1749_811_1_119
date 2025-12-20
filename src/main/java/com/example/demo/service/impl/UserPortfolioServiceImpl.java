package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.model.User;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserPortfolioService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public UserPortfolioServiceImpl(UserPortfolioRepository portfolioRepository, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        User user = userRepository.findById(portfolio.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        portfolio.setUser(user);
        portfolio.setCreatedAt(LocalDateTime.now());
        return portfolioRepository.save(portfolio);
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return portfolioRepository.findByUserId(userId);
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        UserPortfolio existing = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        existing.setPortfolioName(portfolio.getPortfolioName());
        return portfolioRepository.save(existing);
    }

    @Override
    public void deletePortfolio(Long id) {
        UserPortfolio existing = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        portfolioRepository.delete(existing);
    }
}
