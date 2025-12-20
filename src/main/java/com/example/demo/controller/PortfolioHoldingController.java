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
    public PortfolioHolding addHolding(@PathVariable Long portfolioId,
                                       @PathVariable Long stockId,
                                       @RequestBody PortfolioHolding holding) {
        return holdingService.addHolding(portfolioId, stockId, holding);
    }

    @GetMapping("/{id}")
    public PortfolioHolding getHoldingById(@PathVariable Long id) {
        return holdingService.getHoldingById(id);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getHoldingsByPortfolio(@PathVariable Long portfolioId) {
        return holdingService.getHoldingsByPortfolio(portfolioId);
    }

    @PutMapping("/{id}")
    public PortfolioHolding updateHolding(@PathVariable Long id, @RequestBody PortfolioHolding holding) {
        return holdingService.updateHolding(id, holding);
    }

    @DeleteMapping("/{id}")
    public void deleteHolding(@PathVariable Long id) {
        holdingService.deleteHolding(id);
    }
}
