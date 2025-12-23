package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repo;

    public RiskThresholdServiceImpl(RiskThresholdRepository repo) {
        this.repo = repo;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return repo.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));
        t.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        t.setActive(threshold.isActive());
        return repo.save(t);
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public RiskThreshold getByThresholdName(String thresholdName) {
        return repo.findAll().stream()
                .filter(t -> t.getThresholdName().equals(thresholdName))
                .findFirst().orElse(null);
    }

    @Override
    public List<RiskThreshold> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
