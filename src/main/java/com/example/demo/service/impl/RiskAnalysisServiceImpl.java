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

    private final PortfolioHoldingRepository holdingRepo;
    private final RiskThresholdRepository thresholdRepo;
    private final RiskAnalysisResultRepository analysisRepo;
    private final UserPortfolioRepository portfolioRepo;

    public RiskAnalysisServiceImpl(
            PortfolioHoldingRepository holdingRepo,
            RiskThresholdRepository thresholdRepo,
            RiskAnalysisResultRepository analysisRepo,
            UserPortfolioRepository portfolioRepo) {
        this.holdingRepo = holdingRepo;
        this.thresholdRepo = thresholdRepo;
        this.analysisRepo = analysisRepo;
        this.portfolioRepo = portfolioRepo;
    }

    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        List<PortfolioHolding> holdings = holdingRepo.findByPortfolioId(portfolioId);
        RiskThreshold threshold = thresholdRepo.findByPortfolioId(portfolioId).orElse(null);

        BigDecimal total = holdings.stream()
                .map(PortfolioHolding::getMarketValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        double highest = 0;

        for (PortfolioHolding h : holdings) {
            double percent = h.getMarketValue()
                    .multiply(BigDecimal.valueOf(100))
                    .divide(total, 2, BigDecimal.ROUND_HALF_UP)
                    .doubleValue();
            highest = Math.max(highest, percent);
        }

        boolean highRisk = threshold != null &&
                highest > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult(
                portfolio,
                LocalDateTime.now(),
                highest,
                highRisk
        );

        return analysisRepo.save(result);
    }

    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepo.findByPortfolioId(portfolioId);
    }
}
