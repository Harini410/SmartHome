package com.energy.monitor.repository;

import com.energy.monitor.model.EnergyUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyUsageRepository extends JpaRepository<EnergyUsage, Long> {
    // Spring Data JPA will automatically implement basic CRUD operations
}

