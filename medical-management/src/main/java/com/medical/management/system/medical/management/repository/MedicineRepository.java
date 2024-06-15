package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicineRepository extends JpaRepository<MedicineEntity , Integer> {
   Optional<MedicineEntity> findByName(String name);
   List<MedicineEntity> findByCategory(String name);
   List<MedicineEntity> findByType(String name);

}
