package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserPortfolio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Timestamp;
    private String sector;
    private Boolean active;

    public Stock(Long id,String ticker,String companyName,String sector,Boolean active){
        this.id=id;
        this.ticker=ticker;
        this.companyName=companyName;
        this.sector=sector;
        this.active=active;
    }

    public Stock(){
        
    }

    public void setTicker(String ticker){
        this.ticker=ticker;
    }
    public String getTicker(){
        return this.ticker;
    }
    public void setCompanyname(String companyName){
        this.companyName=companyName;
    }
    public String getCompanyName(){
        return this.companyName;
    }
    public void setSector(String sector){
        this.sector=sector;
    }
    public String getSector(){
        return this.sector;
    }
    public void setActive(Boolean active){
        this.active=active;
    }
    public Boolean getActive(){
        return this.active;
    }
}