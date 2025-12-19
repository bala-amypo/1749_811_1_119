package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingController(PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public PortfolioHolding create(@RequestBody PortfolioHolding holding) {
        return repository.save(holding);
    }

    @GetMapping
    public List<PortfolioHolding> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public PortfolioHolding getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
