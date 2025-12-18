package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/risk-thresholds")
public class RiskThresholdController {
    @Autowired
    private RiskThresholdRepository repository;

    
    @PostMapping
    public RiskThreshold create(@RequestBody RiskThreshold threshold) {
        return repository.save(threshold);
    }

    @GetMapping
    public List<RiskThreshold> getAll() {
        return repository.findAll();
    }

    @GetMapping("/active")
    public RiskThreshold getActive() {
        return repository.findByActiveTrue();
    }
}
