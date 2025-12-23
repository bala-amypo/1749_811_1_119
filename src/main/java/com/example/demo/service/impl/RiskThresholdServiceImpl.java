package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private RiskThreshold threshold;

    @Override
    public RiskThreshold setThreshold(Long portfolioId, RiskThreshold threshold) {
        this.threshold = threshold;
        return threshold;
    }

    @Override
    public RiskThreshold getThresholdForPortfolio(Long portfolioId) {
        return threshold;
    }
}
