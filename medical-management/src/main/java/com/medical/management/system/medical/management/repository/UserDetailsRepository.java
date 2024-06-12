package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Integer> {
    Optional<UserDetailsEntity> findByName(String username);


}
