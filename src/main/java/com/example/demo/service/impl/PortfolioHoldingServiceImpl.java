package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final List<PortfolioHolding> holdings = new ArrayList<>();

    @Override
    public PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding) {
        holdings.add(holding);
        return holding;
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdings;
    }
}
