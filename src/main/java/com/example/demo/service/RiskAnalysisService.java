package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import java.util.List;

public interface RiskAnalysisService {

    RiskAnalysisResult save(
            RiskAnalysisResult riskAnalysisResult);

    List<RiskAnalysisResult> getAll();
}
package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import java.util.List;

public interface RiskAnalysisResultService {

    RiskAnalysisResult save(RiskAnalysisResult result);

    List<RiskAnalysisResult> getAll();

    RiskAnalysisResult getById(Long id);
}
