package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repo;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repo) {
        this.repo = repo;
    }

    @Override
    public PortfolioHolding createHolding(Long portfolioId, Long stockId, PortfolioHolding holding) {
        if (holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        return repo.save(holding);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return repo.findByPortfolioId(portfolioId);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding h = getHoldingById(id);
        h.setQuantity(holding.getQuantity());
        h.setMarketValue(holding.getMarketValue());
        return repo.save(h);
    }

    @Override
    public void deleteHolding(Long id) {
        repo.deleteById(id);
    }
}
