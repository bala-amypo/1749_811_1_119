package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "portfolio_holdings")
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
    private Timestamp lastUpdated;

    @PrePersist
    @PreUpdate
    public void onUpdate() {
        this.lastUpdated = new Timestamp(System.currentTimeMillis());
    }

    public PortfolioHolding() {}

    public Long getId() { return id; }
    public UserPortfolio getPortfolio() { return portfolio; }
    public Stock getStock() { return stock; }
    public Double getQuantity() { return quantity; }
    public BigDecimal getMarketValue() { return marketValue; }
    public Timestamp getLastUpdated() { return lastUpdated; }

    public void setId(Long id) { this.id = id; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }
    public void setStock(Stock stock) { this.stock = stock; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public void setMarketValue(BigDecimal marketValue) { this.marketValue = marketValue; }
    public void setLastUpdated(Timestamp lastUpdated) { this.lastUpdated = lastUpdated; }
}
