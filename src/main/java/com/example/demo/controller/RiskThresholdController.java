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

    @PostMapping
    public RiskThreshold createThreshold(@RequestBody RiskThreshold threshold) {
        return service.createThreshold(threshold);
    }

    @GetMapping("/{id}")
    public RiskThreshold getThresholdById(@PathVariable Long id) {
        return service.getThresholdById(id);
    }

    @GetMapping("/name/{thresholdName}")
    public RiskThreshold getByThresholdName(@PathVariable String thresholdName) {
        return service.getByThresholdName(thresholdName);
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
