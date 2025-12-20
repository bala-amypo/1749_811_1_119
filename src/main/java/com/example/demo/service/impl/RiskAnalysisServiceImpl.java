package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final UserPortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository holdingRepository;
    private final RiskThresholdRepository thresholdRepository;
    private final RiskAnalysisResultRepository analysisRepository;

    public RiskAnalysisServiceImpl(UserPortfolioRepository portfolioRepository,
                                   PortfolioHoldingRepository holdingRepository,
                                   RiskThresholdRepository thresholdRepository,
                                   RiskAnalysisResultRepository analysisRepository) {
        this.portfolioRepository = portfolioRepository;
        this.holdingRepository = holdingRepository;
        this.thresholdRepository = thresholdRepository;
        this.analysisRepository = analysisRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        List<PortfolioHolding> holdings = holdingRepository.findByPortfolioId(portfolioId);

        if (holdings.isEmpty())
            throw new RuntimeException("No holdings found for portfolio");

        BigDecimal totalValue = holdings.stream()
                .map(PortfolioHolding::getMarketValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        double highestPercentage = holdings.stream()
                .mapToDouble(h -> h.getMarketValue().divide(totalValue, 6, BigDecimal.ROUND_HALF_UP).doubleValue() * 100)
                .max()
                .orElse(0);

        // Get threshold
        RiskThreshold threshold = thresholdRepository.findByPortfolioId(portfolioId)
                .orElseThrow(() -> new RuntimeException("Risk threshold not found"));

        boolean isHighRisk = highestPercentage > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult(
                portfolio,
                LocalDateTime.now(),
                highestPercentage,
                isHighRisk
        );

        return analysisRepository.save(result);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepository.findByPortfolioId(portfolioId);
    }
}
