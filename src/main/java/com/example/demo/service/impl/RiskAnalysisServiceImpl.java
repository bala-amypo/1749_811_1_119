package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository analysisRepo;
    private final UserPortfolioRepository portfolioRepo;
    private final PortfolioHoldingRepository holdingRepo;
    private final RiskThresholdRepository thresholdRepo;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository analysisRepo,
            UserPortfolioRepository portfolioRepo,
            PortfolioHoldingRepository holdingRepo,
            RiskThresholdRepository thresholdRepo) {

        this.analysisRepo = analysisRepo;
        this.portfolioRepo = portfolioRepo;
        this.holdingRepo = holdingRepo;
        this.thresholdRepo = thresholdRepo;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        List<PortfolioHolding> holdings =
                holdingRepo.findByThresholdName(thresholdName);

        if (holdings.isEmpty()) {
            throw new RuntimeException("No holdings found");
        }

        double total = holdings.stream()
                .map(h -> h.getMarketValue().doubleValue())
                .reduce(0.0, Double::sum);

        double highestPercent = 0;

        for (PortfolioHolding h : holdings) {
            double percent = (h.getMarketValue().doubleValue() / total) * 100;
            highestPercent = Math.max(highestPercent, percent);
        }

        RiskThreshold threshold =
                thresholdRepo.findByThresholdName(thresholdName).orElse(null);

        boolean highRisk = threshold != null &&
                highestPercent > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(LocalDateTime.now());
        result.setHighestStockPercentage(highestPercent);
        result.setIsHighRisk(highRisk);

        return analysisRepo.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return analysisRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskAnalysisResult not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepo.findByThresholdName(thresholdName);
    }

   
}
