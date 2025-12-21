package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService service;

    public RiskThresholdController(RiskThresholdService service) {
        this.service = service;
    }

    @PostMapping("/portfolio/{portfolioId}")
    public RiskThreshold createThreshold(
            @PathVariable Long portfolioId,
            @RequestBody RiskThreshold threshold) {
        return service.createThreshold(portfolioId, threshold);
    }

    @GetMapping("/{id}")
    public RiskThreshold getThresholdById(@PathVariable Long id) {
        return service.getThresholdById(id);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public RiskThreshold getByPortfolio(@PathVariable Long portfolioId) {
        return service.getByPortfolioId(portfolioId);
    }

    @GetMapping
    public List<RiskThreshold> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public RiskThreshold updateThreshold(
            @PathVariable Long id,
            @RequestBody RiskThreshold threshold) {
        return service.updateThreshold(id, threshold);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
