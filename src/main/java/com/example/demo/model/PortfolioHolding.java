package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "portfolio_holdings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioHolding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    @ManyToOne
    private Stock stock;

    private Double quantity;
    private BigDecimal marketValue;

    public PortfolioHolding(UserPortfolio portfolio, Stock stock, Double quantity, BigDecimal marketValue) {
        this.portfolio = portfolio;
        this.stock = stock;
        this.quantity = quantity;
        this.marketValue = marketValue;
    }
}
