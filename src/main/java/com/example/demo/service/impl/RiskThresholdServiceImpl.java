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
        RiskThreshold existing = getThresholdById(id);
        existing.setThresholdName(threshold.getThresholdName());
        existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existing.setMaxSectorPercentage(threshold.getMaxSectorPercentage());
        existing.setActive(threshold.isActive());   // ✅ CORRECT
        return repo.save(existing);
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));
    }

    @Override
    public RiskThreshold getByThresholdName(String name) {
        return repo.findByThresholdName(name)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));
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
