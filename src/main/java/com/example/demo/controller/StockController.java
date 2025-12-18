package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return service.saveStock(stock);
    }

    @GetMapping
    public List<Stock> getStocks() {
        return service.getAllStocks();
    }
}
