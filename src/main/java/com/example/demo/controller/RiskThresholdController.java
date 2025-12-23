package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping
    public ResponseEntity<RiskThreshold> create(@RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(thresholdService.createThreshold(threshold));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskThreshold> update(
            @PathVariable Long id,
            @RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(thresholdService.updateThreshold(id, threshold));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskThreshold> get(@PathVariable Long id) {
        return ResponseEntity.ok(thresholdService.getThresholdById(id));
    }

    @GetMapping
    public ResponseEntity<List<RiskThreshold>> getAll() {
        return ResponseEntity.ok(thresholdService.getAll());
    }
}
