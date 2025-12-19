package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public UserPortfolioServiceImpl(UserPortfolioRepository portfolioRepository,
                                    UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {

        if (portfolio.getPortfolioName() == null ||
                portfolio.getPortfolioName().trim().isEmpty()) {
            throw new IllegalArgumentException("Portfolio name must not be blank");
        }

        Long userId = portfolio.getUser().getId();

        User user = userRepository.findById(userId)
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

        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return portfolioRepository.findByUserId(userId);
    }
}
