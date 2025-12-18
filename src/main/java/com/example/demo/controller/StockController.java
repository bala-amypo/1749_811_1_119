package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockRepository repository;

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        return repository.save(stock);
    }

    @GetMapping
    public List<Stock> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Stock getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
