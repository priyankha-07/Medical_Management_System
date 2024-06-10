package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<SalesEntity ,Integer> {
}
