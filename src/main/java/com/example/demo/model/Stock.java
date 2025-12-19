package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ticker;

    private String companyName;
    private String sector;
    private Boolean isActive = true;

    @OneToMany(mappedBy = "stock")
    private List<PortfolioHolding> holdings;

    public Stock(String ticker, String companyName, String sector, Boolean isActive) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.sector = sector;
        this.isActive = isActive;
    }
}
