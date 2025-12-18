package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio-holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService service;

    public PortfolioHoldingController(
            PortfolioHoldingService service) {
        this.service = service;
    }

    @PostMapping
    public PortfolioHolding create(
            @RequestBody PortfolioHolding holding) {
        return service.save(holding);
    }

    @GetMapping
    public List<PortfolioHolding> list() {
        return service.getAll();
    }
}
