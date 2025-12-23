package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository repo;
    private final UserPortfolioRepository portfolioRepo;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository repo,
            UserPortfolioRepository portfolioRepo) {
        this.repo = repo;
        this.portfolioRepo = portfolioRepo;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        RiskAnalysisResult r = new RiskAnalysisResult();
        r.setPortfolio(portfolio);
        r.setAnalysisDate(LocalDateTime.now());   // ✅ LocalDateTime matches entity
        r.setHighestStockPercentage(50.0);
        r.setIsHighRisk(false);                   // ✅ correct setter

        return repo.save(r);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Analysis not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repo.findByPortfolioId(portfolioId);
    }
}
