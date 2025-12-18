package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/risk-analysis")
public class RiskAnalysisController {
    @Autowired
    private RiskAnalysisResultRepository repository;

    @PostMapping
    public RiskAnalysisResult create(
            @RequestBody RiskAnalysisResult result) {
        return repository.save(result);
    }

    @GetMapping
    public List<RiskAnalysisResult> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public RiskAnalysisResult getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
