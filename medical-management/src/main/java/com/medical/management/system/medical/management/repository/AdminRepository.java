package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity , Integer> {
    AdminEntity findByName(String name);
}
