package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository thresholdRepository;
    private final UserPortfolioRepository portfolioRepository;

    public RiskThresholdServiceImpl(
            RiskThresholdRepository thresholdRepository,
            UserPortfolioRepository portfolioRepository) {
        this.thresholdRepository = thresholdRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public RiskThreshold create(Long portfolioId, RiskThreshold threshold) {

        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        if (threshold.getMaxSingleStockPercentage() < 0 ||
            threshold.getMaxSingleStockPercentage() > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }

        threshold.setPortfolio(portfolio);
        return thresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold update(Long id, RiskThreshold threshold) {

        RiskThreshold existing = thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskThreshold not found"));

        if (threshold.getMaxSingleStockPercentage() < 0 ||
            threshold.getMaxSingleStockPercentage() > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }

        existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existing.setMaxOverallVolatility(threshold.getMaxOverallVolatility());

        return thresholdRepository.save(existing);
    }

    @Override
    public RiskThreshold getById(Long id) {
        return thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskThreshold not found"));
    }

    @Override
    public RiskThreshold getByPortfolioId(Long portfolioId) {
        return thresholdRepository.findByPortfolioId(portfolioId)
                .orElseThrow(() -> new RuntimeException("RiskThreshold not found"));
    }

    @Override
    public List<RiskThreshold> getAll() {
        return thresholdRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        RiskThreshold threshold = thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskThreshold not found"));
        thresholdRepository.delete(threshold);
    }
}
