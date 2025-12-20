package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-thresholds")
@Tag(name = "Risk Thresholds")
public class RiskThresholdController {

    private final RiskThresholdService service;

    public RiskThresholdController(RiskThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public RiskThreshold create(@RequestBody RiskThreshold threshold) {
        return service.save(threshold);
    }

    @PutMapping("/{id}")
    public RiskThreshold update(@PathVariable Long id, @RequestBody RiskThreshold threshold) {
        return service.update(id, threshold);
    }

    @GetMapping("/active")
    public RiskThreshold getActive() {
        return service.getActive();
    }

    @GetMapping("/{id}")
    public RiskThreshold getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<RiskThreshold> getAll() {
        return service.getAll();
    }
}
