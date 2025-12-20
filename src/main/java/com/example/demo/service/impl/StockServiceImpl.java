package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;

    public StockServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public Stock createStock(Stock stock) {
        repository.findByTicker(stock.getTicker()).ifPresent(s -> {
            throw new IllegalArgumentException("Stock ticker already exists");
        });
        return repository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());
        existing.setTicker(stock.getTicker());
        return repository.save(existing);
    }

    @Override
    public Stock getStockById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    @Override
    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    @Override
    public void deactivateStock(Long id) {
        Stock stock = repository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
        stock.setIsActive(false);
        repository.save(stock);
    }
}
