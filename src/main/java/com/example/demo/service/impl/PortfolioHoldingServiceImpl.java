package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl
        implements PortfolioHoldingService {
    @Autowired
    private PortfolioHoldingRepository repository;

    @Override
    public PortfolioHolding save(PortfolioHolding holding) {
        return repository.save(holding);
    }

    @Override
    public List<PortfolioHolding> getAll() {
        return repository.findAll();
    }

    @Override
    public PortfolioHolding getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
