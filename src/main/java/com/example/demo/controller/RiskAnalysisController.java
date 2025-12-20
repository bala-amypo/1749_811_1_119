package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
@Tag(name = "Risk Analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService service;

    public RiskAnalysisController(RiskAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/analyze/{portfolioId}")
    public RiskAnalysisResult analyze(@PathVariable Long portfolioId) {
        return service.analyze(portfolioId);
    }

    @GetMapping("/{id}")
    public RiskAnalysisResult get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<RiskAnalysisResult> getByPortfolio(@PathVariable Long portfolioId) {
        return service.getByPortfolioId(portfolioId);
    }
}
