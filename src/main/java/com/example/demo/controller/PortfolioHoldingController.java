package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@Tag(name = "Portfolio Holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService service;

    public PortfolioHoldingController(PortfolioHoldingService service) {
        this.service = service;
    }

    @PostMapping
    public PortfolioHolding create(@RequestBody PortfolioHolding holding) {
        return service.save(holding);
    }

    @PutMapping("/{id}")
    public PortfolioHolding update(@PathVariable Long id, @RequestBody PortfolioHolding holding) {
        return service.update(id, holding);
    }

    @GetMapping("/{id}")
    public PortfolioHolding get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getByPortfolio(@PathVariable Long portfolioId) {
        return service.getByPortfolioId(portfolioId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
