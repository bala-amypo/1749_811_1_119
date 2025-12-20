package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService analysisService;

    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/{portfolioId}")
    public RiskAnalysisResult analyzePortfolio(@PathVariable Long portfolioId) {
        return analysisService.analyzePortfolio(portfolioId);
    }

    @GetMapping("/{portfolioId}")
    public List<RiskAnalysisResult> getAnalyses(@PathVariable Long portfolioId) {
        return analysisService.getAnalysesForPortfolio(portfolioId);
    }
}
