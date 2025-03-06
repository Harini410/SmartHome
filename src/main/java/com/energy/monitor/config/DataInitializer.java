package com.energy.monitor.config;

import com.energy.monitor.model.EnergyUsage;
import com.energy.monitor.repository.EnergyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private EnergyUsageRepository energyUsageRepository;
    
    @Override
    public void run(String... args) {
        // Add some sample data
        energyUsageRepository.save(new EnergyUsage("Refrigerator", 2.5));
        energyUsageRepository.save(new EnergyUsage("Air Conditioner", 3.8));
        energyUsageRepository.save(new EnergyUsage("Television", 0.9));
        energyUsageRepository.save(new EnergyUsage("Washing Machine", 1.2));
        
        System.out.println("Sample data initialized!");
    }
}

