package com.example.demo.service;

import com.example.demo.model.RiskThreshold;
import java.util.List;

public interface RiskThresholdService {

    RiskThreshold save(RiskThreshold threshold);

    List<RiskThreshold> getAll();

    RiskThreshold getActive();
}
