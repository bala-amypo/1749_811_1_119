package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;

import java.util.List;

public interface RiskAnalysisService {

    RiskAnalysisResult analyze(Long portfolioId);

    RiskAnalysisResult getById(Long id);

    List<RiskAnalysisResult> getByPortfolio(Long portfolioId);

    List<RiskAnalysisResult> getAll();

    RiskAnalysisResult update(Long id, RiskAnalysisResult result);

    void delete(Long id);
}
