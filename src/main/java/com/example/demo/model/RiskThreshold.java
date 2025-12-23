package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_thresholds")
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thresholdName;
    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;
    private Boolean active;

    public RiskThreshold() {}

    public Long getId() { return id; }
    public String getThresholdName() { return thresholdName; }
    public Double getMaxSingleStockPercentage() { return maxSingleStockPercentage; }
    public Double getMaxSectorPercentage() { return maxSectorPercentage; }
    public Boolean isActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setThresholdName(String thresholdName) { this.thresholdName = thresholdName; }
    public void setMaxSingleStockPercentage(Double maxSingleStockPercentage) { this.maxSingleStockPercentage = maxSingleStockPercentage; }
    public void setMaxSectorPercentage(Double maxSectorPercentage) { this.maxSectorPercentage = maxSectorPercentage; }
    public void setActive(Boolean active) { this.active = active; }
}
