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

    @Override
    public Stock createStock(Stock stock) {
        repo.findByTicker(stock.getTicker()).ifPresent(s -> {
            throw new RuntimeException("Duplicate ticker");
        });
        return repo.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());
        return repo.save(existing);
    }

    @Override
    public Stock getStockById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    @Override
    public List<Stock> getAllStocks() {
        return repo.findAll();
    }

    @Override
    public void deactivateStock(Long id) {
        Stock s = getStockById(id);
        s.setIsActive(false);
        repo.save(s);
    }
}
