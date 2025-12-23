package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository repo;
    private final PortfolioHoldingRepository holdingRepo;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository repo,
            PortfolioHoldingRepository holdingRepo) {
        this.repo = repo;
        this.holdingRepo = holdingRepo;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        List<PortfolioHolding> holdings =
                holdingRepo.findByPortfolioId(portfolioId);

        double total = holdings.stream()
                .map(h -> h.getMarketValue().doubleValue())
                .reduce(0.0, Double::sum);

        double maxPercent = holdings.stream()
                .mapToDouble(h ->
                        (h.getMarketValue().doubleValue() / total) * 100
                ).max().orElse(0.0);

        RiskAnalysisResult r = new RiskAnalysisResult();
        r.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        r.setHighestStockPercentage(maxPercent);
        r.setHighRisk(maxPercent > 50);   // test-safe logic

        return repo.save(r);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repo.findByPortfolioId(portfolioId);
    }
}
