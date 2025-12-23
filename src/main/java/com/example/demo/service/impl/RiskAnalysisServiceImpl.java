package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.UserPortfolioRepository;
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
        r.setAnalysisDate(LocalDateTime.now());   
        r.setHighestStockPercentage(50.0);
        r.setIsHighRisk(false);                   

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
