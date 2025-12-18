package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService service;

    public RiskThresholdController(
            RiskThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public RiskThreshold create(
            @RequestBody RiskThreshold riskThreshold) {
        return service.save(riskThreshold);
    }

    @GetMapping
    public List<RiskThreshold> list() {
        return service.getAll();
    }
}
