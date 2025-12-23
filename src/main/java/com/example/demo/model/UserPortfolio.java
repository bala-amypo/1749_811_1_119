package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_portfolios")
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String portfolioName;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    private Boolean active = true;

    @PrePersist
    public void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public UserPortfolio() {}

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getPortfolioName() { return portfolioName; }
    public Timestamp getCreatedAt() { return createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }
    public void setActive(Boolean active) { this.active = active; }
}
