package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private String companyName;
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

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setTicker(String ticker){
        this.email=ticker;
    }
    public String getEmail(){
        return this.email;
    }
    public void setCgpa(float cgpa){
        this.cgpa=cgpa;
    }
    public float getCgpa(){
        return this.cgpa;
    }
}