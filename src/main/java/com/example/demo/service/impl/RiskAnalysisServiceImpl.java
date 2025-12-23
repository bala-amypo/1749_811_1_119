package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final List<RiskAnalysisResult> results = new ArrayList<>();

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult r = new RiskAnalysisResult();
        r.setAnalysisDate(LocalDateTime.now());
        r.setHighestStockPercentage(50.0);
        r.setIsHighRisk(false);
        results.add(r);
        return r;
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return results;
    }
}
