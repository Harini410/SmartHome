package com.energy.monitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class EnergyUsage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String appliance;
    private Double energyConsumed;
    private LocalDateTime timestamp;
    
    // Default constructor
    public EnergyUsage() {
        this.timestamp = LocalDateTime.now();
    }
    
    // Constructor with parameters
    public EnergyUsage(String appliance, Double energyConsumed) {
        this.appliance = appliance;
        this.energyConsumed = energyConsumed;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAppliance() {
        return appliance;
    }
    
    public void setAppliance(String appliance) {
        this.appliance = appliance;
    }
    
    public Double getEnergyConsumed() {
        return energyConsumed;
    }
    
    public void setEnergyConsumed(Double energyConsumed) {
        this.energyConsumed = energyConsumed;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

