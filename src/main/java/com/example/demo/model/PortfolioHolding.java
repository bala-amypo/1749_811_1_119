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
    @JoinColumn(name = "portfolio_id", nullable = false)
    private UserPortfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private BigDecimal marketValue;

    @Column(name = "last_updated", nullable = false)
    private Timestamp lastUpdated;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.lastUpdated = new Timestamp(System.currentTimeMillis());
    }

    public PortfolioHolding() {}

    public PortfolioHolding(UserPortfolio portfolio, Stock stock, Double quantity, BigDecimal marketValue) {
        this.portfolio = portfolio;
        this.stock = stock;
        this.quantity = quantity;
        this.marketValue = marketValue;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }
    public Stock getStock() { return stock; }
    public void setStock(Stock stock) { this.stock = stock; }
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public BigDecimal getMarketValue() { return marketValue; }
    public void setMarketValue(BigDecimal marketValue) { this.marketValue = marketValue; }
    public Timestamp getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Timestamp lastUpdated) { this.lastUpdated = lastUpdated; }
}
