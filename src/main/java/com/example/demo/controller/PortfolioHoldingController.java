package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService holdingService;

    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @PostMapping("/{portfolioId}/{stockId}")
    public PortfolioHolding addHolding(
            @PathVariable Long portfolioId,
            @PathVariable Long stockId,
            @RequestBody PortfolioHolding holding) {
        return holdingService.addHolding(portfolioId, stockId, holding);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getHoldings(@PathVariable Long portfolioId) {
        return holdingService.getHoldingsByPortfolio(portfolioId);
    }
}
