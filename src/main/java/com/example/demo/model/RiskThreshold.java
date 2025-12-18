package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double maxSingleStockPercentage;
    private double maxSectorPercentage;

    public RiskThreshold() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getMaxStockPercent() { return maxSingleStockPercentage; }
    public void setMaxStockPercent(double maxSingleStockPercentage) {
        this.maxSingleStockPercentage = maxSingleStockPercentage;
    }

    public double getMaxSectorPercent() { return maxSectorPercentage; }
    public void setMaxSectorPercent(double maxSectorPercentage) {
        this.maxSectorPercentage = maxSectorPercentage;
    }
}
