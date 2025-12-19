package com.example.demo.repository;
import java.util.Optional;
import com.example.demo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
             Optional<Stock> findByTicker(String ticker);
}
