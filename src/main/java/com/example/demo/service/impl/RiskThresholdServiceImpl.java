package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository thresholdRepository;

    public RiskThresholdServiceImpl(RiskThresholdRepository thresholdRepository) {
        this.thresholdRepository = thresholdRepository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {

        if (threshold.getMaxSingleStockPercentage() < 0 ||
            threshold.getMaxSingleStockPercentage() > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }

        if (threshold.getMaxSectorPercentage() < 0 ||
            threshold.getMaxSectorPercentage() > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }

        return thresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {

        RiskThreshold existing = thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskThreshold not found"));

        existing.setThresholdName(threshold.getThresholdName());
        existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existing.setMaxSectorPercentage(threshold.getMaxSectorPercentage());
        existing.setActive(threshold.isActive());

        return thresholdRepository.save(existing);
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskThreshold not found"));
    }

    @Override
    public RiskThreshold getByThresholdName(String thresholdName) {
        return thresholdRepository.findByThresholdName(thresholdName)
                .orElseThrow(() -> new RuntimeException("RiskThreshold not found"));
    }

    @Override
    public List<RiskThreshold> getAll() {
        return thresholdRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        RiskThreshold threshold = thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskThreshold not found"));
        thresholdRepository.delete(threshold);
    }
}
