package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final List<Stock> stocks = new ArrayList<>();

    @Override
    public Stock createStock(Stock stock) {
        stocks.add(stock);
        return stock;
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        return stock;
    }

    @Override
    public Stock getStockById(Long id) {
        return stocks.stream().findFirst().orElse(null);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stocks;
    }

    @Override
    public void deactivateStock(Long id) {
   
    }
}
