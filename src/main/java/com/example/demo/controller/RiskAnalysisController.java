package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risk-analysis-results")
public class RiskAnalysisController {

    private final RiskAnalysisService service;

    public RiskAnalysisController(
            RiskAnalysisResultService service) {
        this.service = service;
    }

    @PostMapping
    public RiskAnalysisResult create(
            @RequestBody RiskAnalysisResult result) {
        return service.save(result);
    }

    @GetMapping
    public List<RiskAnalysisResult> list() {
        return service.getAll();
    }
}
