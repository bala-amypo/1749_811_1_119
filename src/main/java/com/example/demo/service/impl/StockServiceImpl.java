package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;

    public StockServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public Stock save(Stock stock) {
        return repository.save(stock);
    }

    @Override
    public List<Stock> getAll() {
        return repository.findAll();
    }

    @Override
    public Stock getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
