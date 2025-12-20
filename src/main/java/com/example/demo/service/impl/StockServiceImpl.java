package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Stock stock) {
        if(stockRepository.findByTicker(stock.getTicker()).isPresent()) {
            throw new IllegalArgumentException("Stock ticker already exists");
        }
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existing = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
        existing.setTicker(stock.getTicker());
        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());
        existing.setIsActive(stock.getIsActive());
        return stockRepository.save(existing);
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void deactivateStock(Long id) {
        Stock existing = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
        existing.setIsActive(false);
        stockRepository.save(existing);
    }
}
