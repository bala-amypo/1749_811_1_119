package com.example.demo.service;

import com.example.demo.model.RiskThreshold;

import java.util.List;

public interface RiskThresholdService {

    RiskThreshold createThreshold(Long portfolioId, RiskThreshold threshold);

    RiskThreshold updateThreshold(Long id, RiskThreshold threshold);

    RiskThreshold getThresholdById(Long id);

    RiskThreshold getByPortfolioId(Long portfolioId);

    List<RiskThreshold> getAll();

    void delete(Long id);
}
