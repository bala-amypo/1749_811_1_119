package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository thresholdRepository;
    private final UserPortfolioRepository portfolioRepository;

    public RiskThresholdServiceImpl(RiskThresholdRepository thresholdRepository,
                                    UserPortfolioRepository portfolioRepository) {
        this.thresholdRepository = thresholdRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public RiskThreshold setThreshold(Long portfolioId, RiskThreshold threshold) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        if (threshold.getMaxSingleStockPercentage() < 0 || threshold.getMaxSingleStockPercentage() > 100)
            throw new IllegalArgumentException("maxSingleStockPercentage must be between 0 and 100");

        threshold.setPortfolio(portfolio);
        return thresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold getThresholdForPortfolio(Long portfolioId) {
        return thresholdRepository.findByPortfolioId(portfolioId)
                .orElseThrow(() -> new RuntimeException("Risk threshold not found for portfolio"));
    }
}
