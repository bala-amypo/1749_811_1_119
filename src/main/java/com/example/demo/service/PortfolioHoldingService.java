package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import java.util.List;

public interface PortfolioHoldingService {

    PortfolioHolding save(PortfolioHolding holding);

    List<PortfolioHolding> getAll();

    PortfolioHolding getById(Long id);
}
