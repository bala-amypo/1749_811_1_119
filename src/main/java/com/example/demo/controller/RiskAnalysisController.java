package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService service;

    public RiskAnalysisController(RiskAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/portfolio/{portfolioId}")
    public RiskAnalysisResult analyze(@PathVariable Long portfolioId) {
        return service.analyze(portfolioId);
    }

    @GetMapping("/{id}")
    public RiskAnalysisResult getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<RiskAnalysisResult> getByPortfolio(
            @PathVariable Long portfolioId) {
        return service.getByPortfolio(portfolioId);
    }

    @GetMapping
    public List<RiskAnalysisResult> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public RiskAnalysisResult update(
            @PathVariable Long id,
            @RequestBody RiskAnalysisResult result) {
        return service.update(id, result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
