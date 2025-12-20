package com.example.demo.service;

import com.example.demo.model.RiskThreshold;

import java.util.List;

public interface RiskThresholdService {

    RiskThreshold create(Long portfolioId, RiskThreshold threshold);

    RiskThreshold update(Long id, RiskThreshold threshold);

    RiskThreshold getById(Long id);

    RiskThreshold getByPortfolioId(Long portfolioId);

    List<RiskThreshold> getAll();

    void delete(Long id);
}
