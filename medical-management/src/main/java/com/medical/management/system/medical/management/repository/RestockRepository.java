package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.RestockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestockRepository extends JpaRepository<RestockEntity , Integer> {
}
