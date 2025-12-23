package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private Timestamp analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private Boolean IsHighRisk;
    private String notes;

    public RiskAnalysisResult() {}

    @PrePersist
    public void onCreate() {
        this.analysisDate = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { return id; }
    public UserPortfolio getPortfolio() { return portfolio; }
    public Timestamp getAnalysisDate() { return analysisDate; }
    public Double getHighestStockPercentage() { return highestStockPercentage; }
    public Double getHighestSectorPercentage() { return highestSectorPercentage; }
    public Boolean IsHighRisk() { return IsHighRisk; }
    public String getNotes() { return notes; }

    public void setId(Long id) { this.id = id; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }
    public void setAnalysisDate(Timestamp analysisDate) { this.analysisDate = analysisDate; }
    public void setHighestStockPercentage(Double highestStockPercentage) { this.highestStockPercentage = highestStockPercentage; }
    public void setHighestSectorPercentage(Double highestSectorPercentage) { this.highestSectorPercentage = highestSectorPercentage; }
    public void setIsHighRisk(Boolean highRisk) { IsHighRisk = highRisk; }
    public void setNotes(String notes) { this.notes = notes; }
}
