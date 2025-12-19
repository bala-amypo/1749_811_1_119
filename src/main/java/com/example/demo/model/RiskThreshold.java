package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "risk_thresholds")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private Double maxSingleStockPercentage;
    private Double maxOverallVolatility;

    public RiskThreshold(UserPortfolio portfolio, Double maxSingleStockPercentage, Double maxOverallVolatility) {
        this.portfolio = portfolio;
        this.maxSingleStockPercentage = maxSingleStockPercentage;
        this.maxOverallVolatility = maxOverallVolatility;
    }
}
