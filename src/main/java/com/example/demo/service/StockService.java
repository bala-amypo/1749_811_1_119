package com.example.demo.service;

import com.example.demo.model.Stock;
import java.util.List;

public interface StockService {

    Stock save(Stock stock);

    List<Stock> getAll();

    Stock getById(Long id);
}
