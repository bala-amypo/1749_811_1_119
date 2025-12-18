package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double maxStockPercent;
    private double maxSectorPercent;

    public RiskThreshold() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getMaxStockPercent() { return maxStockPercent; }
    public void setMaxStockPercent(double maxStockPercent) {
        this.maxStockPercent = maxStockPercent;
    }

    public double getMaxSectorPercent() { return maxSectorPercent; }
    public void setMaxSectorPercent(double maxSectorPercent) {
        this.maxSectorPercent = maxSectorPercent;
    }
}
