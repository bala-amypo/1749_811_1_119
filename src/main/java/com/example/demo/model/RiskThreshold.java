package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "risk_thresholds",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"threshold_name"})
        }
)
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "threshold_name", nullable = false, unique = true)
    private String thresholdName;

    @Column(nullable = false)
    private double maxSingleStockPercentage;

    @Column(nullable = false)
    private double maxSectorPercentage;

    @Column(nullable = false)
    private boolean active;

    public RiskThreshold() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThresholdName() {
        return thresholdName;
    }

    public void setThresholdName(String thresholdName) {
        this.thresholdName = thresholdName;
    }

    public double getMaxSingleStockPercentage() {
        return maxSingleStockPercentage;
    }

    public void setMaxSingleStockPercentage(double maxSingleStockPercentage) {
        this.maxSingleStockPercentage = maxSingleStockPercentage;
    }

    public double getMaxSectorPercentage() {
        return maxSectorPercentage;
    }

    public void setMaxSectorPercentage(double maxSectorPercentage) {
        this.maxSectorPercentage = maxSectorPercentage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
