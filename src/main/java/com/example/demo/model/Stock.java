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

    public StudentEntity(Long id,String name,String email,float cgpa){
        this.id=id;
        this.name=name;
        this.email=email;
        this.cgpa=cgpa;
    }

    public StudentEntity(){
        
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String email){
        this.email=email;
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