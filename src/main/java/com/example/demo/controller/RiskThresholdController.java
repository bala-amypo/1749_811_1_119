package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping("/{portfolioId}")
    public ResponseEntity<RiskThreshold> setThreshold(
            @PathVariable Long portfolioId,
            @RequestBody RiskThreshold threshold) {

        return ResponseEntity.ok(
                thresholdService.setThreshold(portfolioId, threshold)
        );
    }

    @GetMapping("/{portfolioId}")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(
                thresholdService.getThresholdForPortfolio(portfolioId)
        );
    }
}
