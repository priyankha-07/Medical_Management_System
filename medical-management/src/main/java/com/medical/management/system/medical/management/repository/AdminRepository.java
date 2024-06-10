package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity , Integer> {
    AdminEntity findByName(String name);
}
