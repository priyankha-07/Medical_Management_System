package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    Optional<EmployeeEntity > findByName(String name);
}
