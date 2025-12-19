package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepo;
    private final UserPortfolioRepository portfolioRepo;
    private final StockRepository stockRepo;

    public PortfolioHoldingServiceImpl(
            PortfolioHoldingRepository holdingRepo,
            UserPortfolioRepository portfolioRepo,
            StockRepository stockRepo) {
        this.holdingRepo = holdingRepo;
        this.portfolioRepo = portfolioRepo;
        this.stockRepo = stockRepo;
    }

    public PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding) {

        if (holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (holding.getMarketValue().signum() < 0) {
            throw new IllegalArgumentException("Market value must be non-negative");
        }

        UserPortfolio portfolio = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        Stock stock = stockRepo.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));

        holding.setPortfolio(portfolio);
        holding.setStock(stock);

        return holdingRepo.save(holding);
    }

    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepo.findByPortfolioId(portfolioId);
    }
}
