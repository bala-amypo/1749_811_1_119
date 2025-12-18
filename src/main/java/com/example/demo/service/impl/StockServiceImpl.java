package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repo;

    public StockServiceImpl(StockRepository repo) {
        this.repo = repo;
    }

    public Stock saveStock(Stock stock) {
        return repo.save(stock);
    }

    public List<Stock> getAllStocks() {
        return repo.findAll();
    }
}
