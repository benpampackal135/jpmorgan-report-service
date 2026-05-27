package com.jpmorgan.report_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "reports")
public class Report{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    private String status;

    public Report(){}

    public Report(String name, String type, String status){
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status){
        this.status = status;

    }

}

