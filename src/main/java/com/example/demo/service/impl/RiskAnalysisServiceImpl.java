package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RiskAnalysisServiceImpl
        implements RiskAnalysisService {
            
   private final RiskAnalysisResultRepository repository;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository repository) {
        this.repository = repository;
    }
    @Override
    public RiskAnalysisResult save(
            RiskAnalysisResult riskAnalysisResult) {
        return repository.save(riskAnalysisResult);
    }

    @Override
    public List<RiskAnalysisResult> getAll() {
        return repository.findAll();
    }

    @Override
    public RiskAnalysisResult getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
