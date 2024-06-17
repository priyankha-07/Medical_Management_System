//package com.medical.management.system.medical.management.repository;

package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {

    @Query("SELECT SUM(s.totalAmount) AS totalRevenue, " +
            "SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
            "FROM SalesEntity s " +
            "JOIN RestockEntity r ON s.medicineId = r.medicineId " +
            "WHERE s.soldDate BETWEEN :startDate AND :endDate")
    Map<String, Double> getTotalRevenueAndProfitForDateRange(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);


    @Query("SELECT SUM(s.totalAmount) AS totalRevenue FROM SalesEntity s  JOIN RestockEntity r ON s.medicineId = r.medicineId WHERE s.soldDate = :date")
    double getTotalRevenueAndProfitForDate(@Param("date") String date);


}





