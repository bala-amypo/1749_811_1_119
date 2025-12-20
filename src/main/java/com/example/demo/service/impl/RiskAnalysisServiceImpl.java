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
    public RiskAnalysisResult analyze(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        List<PortfolioHolding> holdings =
                holdingRepo.findByPortfolioId(portfolioId);

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
                thresholdRepo.findByPortfolioId(portfolioId).orElse(null);

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
    public RiskAnalysisResult getById(Long id) {
        return analysisRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskAnalysisResult not found"));
    }

    @Override
    public List<RiskAnalysisResult> getByPortfolio(Long portfolioId) {
        return analysisRepo.findByPortfolioId(portfolioId);
    }

    @Override
    public List<RiskAnalysisResult> getAll() {
        return analysisRepo.findAll();
    }

    @Override
    public RiskAnalysisResult update(Long id, RiskAnalysisResult updated) {

        RiskAnalysisResult existing = getById(id);

        existing.setHighestStockPercentage(updated.getHighestStockPercentage());
        existing.setIsHighRisk(updated.getIsHighRisk());

        return analysisRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        RiskAnalysisResult result = getById(id);
        analysisRepo.delete(result);
    }
}
