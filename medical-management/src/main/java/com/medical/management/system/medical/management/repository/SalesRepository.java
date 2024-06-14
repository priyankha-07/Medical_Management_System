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

import com.medical.management.system.medical.management.entity.RevenueProfitDTO;
import com.medical.management.system.medical.management.entity.SalesEntity;
import jakarta.persistence.Temporal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
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


//    @Query("SELECT SUM(s.totalAmount) AS totalRevenue, " +
//            "SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
//            "FROM SalesEntity s " +
//            "JOIN RestockEntity r ON s.medicineId = r.medicineId " +
//            "WHERE FUNCTION('MONTH', TO_DATE(s.soldDate, 'DD-MM-YYYY')) = :month " +
//            "AND FUNCTION('YEAR', TO_DATE(s.soldDate, 'DD-MM-YYYY')) = :year")
//    Map<String, Double> findByMonthAndYear(@Param("month") String month, @Param("year") String year);
//}

    @Query("SELECT SUM(s.totalAmount) AS totalRevenue, " +
            "SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
            "FROM SalesEntity s " +
            "JOIN RestockEntity r ON s.medicineId = r.medicineId " +
            "WHERE (:year IS NULL OR EXTRACT(YEAR FROM s.soldDate) = CAST(:year AS int)) " +
            "AND (:month IS NULL OR EXTRACT(MONTH FROM s.soldDate) = CAST(:month AS int))")
    RevenueProfitDTO findByMonthAndYear(@Param("month") String month,
                                        @Param("year") String year);
}

//
//
//    @Query("SELECT SUM(s.sellingPrice) as totalRevenue, " +
//            "((SUM(s.sellingPrice) - SUM(r.buyingPrice)) / SUM(r.buyingPrice)) * 100 as profitPercentage " +
//            "FROM SalesEntity s, RestockEntity r " +
//            "WHERE s.soldDate LIKE :yearMonth% ")
//    Object[] getRevenueAndProfitPercentage(@Param("yearMonth") String yearMonth);

//    @Query("SELECT SUM(s.sellingPrice) as totalRevenue, " +
//            "CASE WHEN SUM(r.buyingPrice) = 0 THEN 0 " +
//            "ELSE ((SUM(s.sellingPrice) - SUM(r.buyingPrice)) / SUM(r.buyingPrice)) * 100 END as profitPercentage " +
//            "FROM SalesEntity s JOIN RestockEntity r ON s.medicineId = r.medicineId " +
//            "WHERE YEAR(s.soldDate) = :year AND MONTH(s.soldDate) = :month")
//    Object[] getRevenueAndProfitPercentage(@Param("year") int year, @Param("month") int month);
//}

//    @Query("SELECT SUM(s.sellingPrice) as totalRevenue, " +
//            "CASE WHEN SUM(r.buyingPrice) = 0 THEN 0 " +
//            "ELSE ((SUM(s.sellingPrice) - SUM(r.buyingPrice)) / SUM(r.buyingPrice)) * 100 END as profitPercentage " +
//            "FROM SalesEntity s JOIN RestockEntity r ON s.medicineId = r.medicineId " +
//            "WHERE YEAR(s.soldDate) = :year AND MONTH(s.soldDate) = :month")
//    Object[] getRevenueAndProfitPercentage(@Param("year") int year, @Param("month") int month);
//}

//    @Query("SELECT SUM(s.totalAmount) AS totalRevenue, " +
//            "SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
//            "FROM SalesEntity s " +
//            "JOIN RestockEntity r ON s.medicineId = r.medicineId ")
//    Map<String, Double> findBySumOfTotalRevenueAndProfitPercentager();
////
////    @Query("SELECT s FROM SalesEntity s " +
//                  "WHERE MONTH(s.soldDate) = :month " +
//                  "AND YEAR(s.soldDate) = :year")  // Use MONTH and YEAR directly
//    List<SalesEntity> findByMonthAndYear(@Param("month") String month, @Param("year") Str year);

//             @Query("SELECT SUM(s.totalAmount) AS totalRevenue, " +
//            "SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
//            "FROM SalesEntity s " +
//            "JOIN RestockEntity r ON s.medicineId = r.medicineId "+
//                     "WHERE EXTRACT(YEAR FROM TO_DATE(s.soldDate, 'DD-MM-YYYY')) = :year " +
//            "AND EXTRACT(MONTH FROM TO_DATE(s.soldDate, 'DD-MM-YYYY')) = :month")
//           Map<String, Double> findByMonthAndYear(@Param("month") String month, @Param("year") String year);
//}
////@Query("SELECT SUM(s.totalAmount) AS totalRevenue, " +
//        "SUM((s.sellingPrice - r.buyingPrice) * s.quantitySold) AS totalProfit " +
//        "FROM SalesEntity s " +
//        "JOIN RestockEntity r ON s.medicineId = r.medicineId " +
//        "WHERE YEAR(TO_DATE(s.soldDate, 'DD-MM-YYYY')) = :year " +
//        "AND MONTH(TO_DATE(s.soldDate, 'DD-MM-YYYY')) = :month")
//Map<String, Double> findByMonthAndYear(@Param("month") String month, @Param("year") String year);
//}

