package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl
        implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingServiceImpl(
            PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioHolding save(PortfolioHolding holding) {
         if (quantity <= 0) {
            throw new RuntimeException("Quantity must be > 0");
        }
        return repository.save(holding);
    }

    @Override
    public List<PortfolioHolding> getAll() {
        return repository.findAll();
    }

    @Override
    public PortfolioHolding getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
