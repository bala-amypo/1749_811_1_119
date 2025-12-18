package com.example.demo.service;

import com.example.demo.model.RiskThreshold;
import java.util.List;

public interface RiskThresholdService {

    RiskThreshold save(RiskThreshold riskThreshold);

    List<RiskThreshold> getAll();
}
