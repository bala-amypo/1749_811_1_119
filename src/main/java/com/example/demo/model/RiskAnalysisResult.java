package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_analysis_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskAnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private LocalDateTime analysisDate;
    private Double highestStockPercentage;
    private Boolean isHighRisk;

    public RiskAnalysisResult(UserPortfolio portfolio, LocalDateTime analysisDate, Double highestStockPercentage, Boolean isHighRisk) {
        this.portfolio = portfolio;
        this.analysisDate = analysisDate;
        this.highestStockPercentage = highestStockPercentage;
        this.isHighRisk = isHighRisk;
    }
}
