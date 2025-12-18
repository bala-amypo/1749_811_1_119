package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskThresholdServiceImpl
        implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(
            RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold save(RiskThreshold riskThreshold) {
        return repository.save(riskThreshold);
    }

    @Override
    public List<RiskThreshold> getAll() {
        return repository.findAll();
    }
}
