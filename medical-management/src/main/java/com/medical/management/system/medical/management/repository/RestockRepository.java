package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.RestockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestockRepository extends JpaRepository<RestockEntity, Integer> {

    @Query("SELECT r.buyingPrice FROM RestockEntity r WHERE r.medicineId = :medicineId")
    Double getBuyingPriceForProduct(@Param("medicineId") int medicineId);
}

