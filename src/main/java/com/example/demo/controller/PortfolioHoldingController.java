package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PortfolioHolding> addHolding(
            @PathVariable Long portfolioId,
            @PathVariable Long stockId,
            @RequestBody PortfolioHolding holding) {

        return ResponseEntity.ok(
                holdingService.addHolding(portfolioId, stockId, holding)
        );
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> getHoldings(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(
                holdingService.getHoldingsByPortfolio(portfolioId)
        );
    }
}
