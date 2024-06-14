//package com.medical.management.system.medical.management.repository;
//
//import com.medical.management.system.medical.management.entity.SalesEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.Map;
//
//@Repository
//public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {
//    // Total revenue for a specific date
//    @Query("SELECT SUM(s.totalAmount) AS totalRevenue FROM SalesEntity s WHERE s.soldDate = :date")
//    Double getTotalRevenueForDate(@Param("date") String date);
//
//    // Total profit for a specific date
//    @Query("SELECT SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
//            "FROM SalesEntity s " +
//            "INNER JOIN RestockEntity r ON s.medicineId = r.medicineId " +
//            "WHERE s.soldDate = :date")
//    Double getTotalProfitForDate(@Param("date") String date);
//
//    // Total revenue and profit for a date range
//    @Query("SELECT SUM(s.totalAmount) AS totalRevenue, SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
//            "FROM SalesEntity s " +
//            "INNER JOIN RestockEntity r ON s.medicineId = r.medicineId " +
//            "WHERE s.soldDate BETWEEN :startDate AND :endDate")
//    Map<String, Double> getTotalRevenueAndProfitForDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
//}
package com.medical.management.system.medical.management.repository;

import com.medical.management.system.medical.management.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {

    // Query for total revenue and profit for a date range (MTD and EOM)
    @Query("SELECT SUM(s.totalAmount) AS totalRevenue, " +
            "SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
            "FROM SalesEntity s " +
            "JOIN RestockEntity r ON s.medicineId = r.medicineId " +
            "WHERE s.soldDate BETWEEN :startDate AND :endDate")
    Map<String, Double> getTotalRevenueAndProfitForDateRange(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);

    //query for daily report
    @Query("SELECT SUM(s.totalAmount) AS totalRevenue FROM SalesEntity s  JOIN RestockEntity r ON s.medicineId = r.medicineId WHERE s.soldDate = :date")
    double getTotalRevenueAndProfitForDate(@Param("date") String date);

    @Query("SELECT SUM(s.totalAmount) AS totalRevenue, " +
            "SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
            "FROM SalesEntity s " +
            "JOIN RestockEntity r ON s.medicineId = r.medicineId " )
    Map<String, Double> getTotalRevenueAndProfitForEOM(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
}





