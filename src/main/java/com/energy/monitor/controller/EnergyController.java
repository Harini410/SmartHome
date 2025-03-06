package com.energy.monitor.controller;

import com.energy.monitor.model.EnergyUsage;
import com.energy.monitor.repository.EnergyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energy")
@CrossOrigin(origins = "*") // Allow requests from any origin for simplicity
public class EnergyController {
    
    @Autowired
    private EnergyUsageRepository energyUsageRepository;
    
    @PostMapping("/add")
    public ResponseEntity<EnergyUsage> addEnergyUsage(@RequestBody EnergyUsage energyUsage) {
        EnergyUsage savedUsage = energyUsageRepository.save(energyUsage);
        return ResponseEntity.ok(savedUsage);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<EnergyUsage>> getAllEnergyUsage() {
        List<EnergyUsage> usages = energyUsageRepository.findAll();
        return ResponseEntity.ok(usages);
    }
}

