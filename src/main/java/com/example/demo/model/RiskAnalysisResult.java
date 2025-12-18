package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long portfolioId;
    private double highestStockPercentage;
    private double highestSectorPercentage;
    private boolean highRisk;
    private String message;

    public RiskAnalysisResult() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPortfolioId() { return portfolioId; }
    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public double getHighestStockPercentage() {
        return highestStockPercentage;
    }
    public void setHighestStockPercentage(double v) {
        this.highestStockPercentage = v;
    }

    public double getHighestSectorPercentage() {
        return highestSectorPercentage;
    }
    public void setHighestSectorPercentage(double v) {
        this.highestSectorPercentage = v;
    }

    public boolean isHighRisk() { return highRisk; }
    public void setHighRisk(boolean highRisk) {
        this.highRisk = highRisk;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) {
        this.message = message;
    }
}
