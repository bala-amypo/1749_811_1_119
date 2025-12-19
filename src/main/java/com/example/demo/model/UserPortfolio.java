package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_portfolios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String portfolioName;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "portfolio")
    private List<PortfolioHolding> holdings;

    @OneToMany(mappedBy = "portfolio")
    private List<RiskAnalysisResult> analyses;

    public UserPortfolio(User user, String portfolioName, LocalDateTime createdAt) {
        this.user = user;
        this.portfolioName = portfolioName;
        this.createdAt = createdAt;
    }
}
