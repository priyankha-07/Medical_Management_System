package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    EmployeeEntity findByName(String name);
}
