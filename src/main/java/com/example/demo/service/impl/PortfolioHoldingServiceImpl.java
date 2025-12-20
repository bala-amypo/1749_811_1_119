package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.UserPortfolio;
import com.example.demo.model.Stock;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository holdingRepository,
                                      UserPortfolioRepository portfolioRepository,
                                      StockRepository stockRepository) {
        this.holdingRepository = holdingRepository;
        this.portfolioRepository = portfolioRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public PortfolioHolding addHolding(Long portfolioId, Long stockId, PortfolioHolding holding) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));

        if (holding.getQuantity() <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero");
        if (holding.getMarketValue().doubleValue() < 0)
            throw new IllegalArgumentException("Market value must be zero or positive");

        holding.setPortfolio(portfolio);
        holding.setStock(stock);

        return holdingRepository.save(holding);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return holdingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holding not found"));
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existing = holdingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holding not found"));

        if (holding.getQuantity() <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero");
        if (holding.getMarketValue().doubleValue() < 0)
            throw new IllegalArgumentException("Market value must be zero or positive");

        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());
        return holdingRepository.save(existing);
    }

    @Override
    public void deleteHolding(Long id) {
        PortfolioHolding existing = holdingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holding not found"));
        holdingRepository.delete(existing);
    }
}
