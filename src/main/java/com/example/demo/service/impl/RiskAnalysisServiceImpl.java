package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository repo;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository repo) {
        this.repo = repo;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult r = new RiskAnalysisResult();
        r.setAnalysisDate(LocalDateTime.now());
        r.setHighestStockPercentage(50.0);
        r.setIsHighRisk(false);
        return repo.save(r);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repo.findByPortfolioId(portfolioId);
    }
}
