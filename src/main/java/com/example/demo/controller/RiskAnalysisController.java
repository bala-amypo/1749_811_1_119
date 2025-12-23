package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RiskAnalysisResult> analyze(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(
                analysisService.analyzePortfolio(portfolioId)
        );
    }

    @GetMapping("/{portfolioId}")
    public ResponseEntity<List<RiskAnalysisResult>> getResults(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(
                analysisService.getAnalysesForPortfolio(portfolioId)
        );
    }
}
