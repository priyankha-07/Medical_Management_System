package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<MedicineEntity , Integer> {
    MedicineEntity findByName(String name);
}
