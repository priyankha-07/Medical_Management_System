package com.medical.management.system.medical.management.controller;

import com.medical.management.system.medical.management.entity.Dates;
import com.medical.management.system.medical.management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

////package com.medical.management.system.medical.management.controller;
////
////import com.medical.management.system.medical.management.entity.Dates;
////import com.medical.management.system.medical.management.repository.SalesRepository;
////import com.medical.management.system.medical.management.service.CsvGenerator;
////import jakarta.servlet.http.HttpServletResponse;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////import java.io.IOException;
////import java.io.PrintWriter;
////import java.util.Map;
////@RestController
////@RequestMapping("/reports")
////public class SalesReportController {
////
////    @Autowired
////    private SalesRepository salesRepository;
////
////    @PostMapping("/daily-report")
////    public void getDailyReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
////        String date = dateRequest.getDate();
////        Double totalRevenue = salesRepository.getTotalRevenueForDate(date);
////        Double totalProfit = salesRepository.getTotalProfitForDate(date);
////
////        response.setContentType("text/csv");
////        response.setHeader("Content-Disposition", "attachment; filename=\"daily-report.csv\"");
////
////        PrintWriter writer = response.getWriter();
////        CsvGenerator.generateDailyCsv(totalRevenue, totalProfit, writer);
////
////        writer.close();
////    }
////
////    @PostMapping("/mtd-report")
////    public void getMTDReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
////        String endDate = dateRequest.getDate();
////        String startDate = getStartDateOfMonth(endDate);
////        Map<String, Double> revenueAndProfit = salesRepository.getTotalRevenueAndProfitForDateRange(startDate, endDate);
////
////        response.setContentType("text/csv");
////        response.setHeader("Content-Disposition", "attachment; filename=\"mtd-report.csv\"");
////
////        PrintWriter writer = response.getWriter();
////        CsvGenerator.generateMTDCsv(revenueAndProfit, writer);
////
////        writer.close();
////    }
////
////    @PostMapping("/eom-report")
////    public void getEOMReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
////        String[] dateParts = dateRequest.getDate().split("-");
////        if (dateParts.length != 3) {
////            throw new IllegalArgumentException("Invalid date format, expected format: dd-mm-yyyy");
////        }
////        String month = dateParts[1];
////        String year = dateParts[2];
////
////        String startDate = "01-" + month + "-" + year;
////        String endDate = getEndDateOfMonth(month, year);
////
////        Map<String, Double> revenueAndProfit = salesRepository.getTotalRevenueAndProfitForDateRange(startDate, endDate);
////
////        response.setContentType("text/csv");
////        response.setHeader("Content-Disposition", "attachment; filename=\"eom-report.csv\"");
////
////        PrintWriter writer = response.getWriter();
////        CsvGenerator.generateEOMCsv(revenueAndProfit, writer);
////
////        writer.close();
////    }
////
////    private String getStartDateOfMonth(String endDate) {
////        return "01-" + endDate.substring(3); // Assuming date format is dd-mm-yyyy
////    }
////
////    private String getEndDateOfMonth(String month, String year) {
////        int monthInt = Integer.parseInt(month);
////        int yearInt = Integer.parseInt(year);
////        int lastDay = java.time.YearMonth.of(yearInt, monthInt).lengthOfMonth();
////        return lastDay + "-" + month + "-" + year;
////    }
////}
////
//////import com.medical.management.system.medical.management.entity.Dates;
//////import com.medical.management.system.medical.management.repository.SalesRepository;
//////import com.medical.management.system.medical.management.service.CsvGenerator;
//////import jakarta.servlet.http.HttpServletResponse;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.web.bind.annotation.*;
//////
//////import java.io.IOException;
//////import java.io.PrintWriter;
//////import java.util.Map;
////
//////@RestController
//////@RequestMapping("/reports")
//////public class SalesReportController {
//////
//////    @Autowired
//////    private SalesRepository salesRepository;
//////
//    @PostMapping("/daily-report")
//    public void getDailyReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
//        String date = dateRequest.getDate();
//        Double totalRevenue = salesRepository.getTotalRevenueForDate(date);
//        Double totalProfit = salesRepository.getTotalProfitForDate(date);
//        if (totalRevenue == null) {
//            totalRevenue = 0.0;
//        }
//        if (totalProfit == null) {
//            totalProfit = 0.0;
//        }
//
//        response.setContentType("text/csv");
//        response.setHeader("Content-Disposition", "attachment; filename=\"daily-report.csv\"");
//
//        PrintWriter writer = response.getWriter();
//        CsvGenerator.generateDailyCsv(totalRevenue, totalProfit, writer);
//
//        writer.close();
//    }
//////
//////    @PostMapping("/mtd-report")
//////    public void getMTDReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
//////        String endDate = dateRequest.getDate();
//////        String startDate = getStartDateOfMonth(endDate);
//////        Map<String, Double> revenueAndProfit = salesRepository.getTotalRevenueAndProfitForDateRange(startDate, endDate);
//////
//////        if (!revenueAndProfit.containsKey("totalRevenue")) {
//////            revenueAndProfit.put("totalRevenue", 0.0);
//////        }
//////        if (!revenueAndProfit.containsKey("totalProfit")) {
//////            revenueAndProfit.put("totalProfit", 0.0);
//////        }
//////
//////        response.setContentType("text/csv");
//////        response.setHeader("Content-Disposition", "attachment; filename=\"mtd-report.csv\"");
//////
//////        PrintWriter writer = response.getWriter();
//////        CsvGenerator.generateMTDCsv(revenueAndProfit, writer);
//////
//////        writer.close();
//////    }
//////
//////    @PostMapping("/eom-report")
//////    public void getEOMReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
//////        String[] dateParts = dateRequest.getDate().split("-");
//////        if (dateParts.length != 3) {
//////            throw new IllegalArgumentException("Invalid date format, expected format: dd-mm-yyyy");
//////        }
//////        String month = dateParts[1];
//////        String year = dateParts[2];
//////
//////        String startDate = "01-" + month + "-" + year;
//////        String endDate = getEndDateOfMonth(month, year);
//////
//////        Map<String, Double> revenueAndProfit = salesRepository.getTotalRevenueAndProfitForDateRange(startDate, endDate);
//////
//////        if (!revenueAndProfit.containsKey("totalRevenue")) {
//////            revenueAndProfit.put("totalRevenue", 0.0);
//////        }
//////        if (!revenueAndProfit.containsKey("totalProfit")) {
//////            revenueAndProfit.put("totalProfit", 0.0);
//////        }
//////
//////        response.setContentType("text/csv");
//////        response.setHeader("Content-Disposition", "attachment; filename=\"eom-report.csv\"");
//////
//////        PrintWriter writer = response.getWriter();
//////        CsvGenerator.generateEOMCsv(revenueAndProfit, writer);
//////
//////        writer.close();
//////    }
//////
//////    @PostMapping("/monthly-report")
//////    public void getMonthlyReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
//////        String[] dateParts = dateRequest.getDate().split("-");
//////        if (dateParts.length != 3) {
//////            throw new IllegalArgumentException("Invalid date format, expected format: dd-mm-yyyy");
//////        }
//////        int month = Integer.parseInt(dateParts[1]);
//////        int year = Integer.parseInt(dateParts[2]);
//////
//////        Map<String, Double> revenueAndProfit = salesRepository.getTotalRevenueAndProfitForMonth(month, year);
//////
//////        if (!revenueAndProfit.containsKey("totalRevenue")) {
//////            revenueAndProfit.put("totalRevenue", 0.0);
//////        }
//////        if (!revenueAndProfit.containsKey("totalProfit")) {
//////            revenueAndProfit.put("totalProfit", 0.0);
//////        }
//////
//////        response.setContentType("text/csv");
//////        response.setHeader("Content-Disposition", "attachment; filename=\"monthly-report.csv\"");
//////
//////        PrintWriter writer = response.getWriter();
//////        CsvGenerator.generateMonthlyCsv(revenueAndProfit, writer);
//////
//////        writer.close();
//////    }
//////
//////    @PostMapping("/yearly-report")
//////    public void getYearlyReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
//////        int year = Integer.parseInt(dateRequest.getDate().split("-")[2]);
//////
//////        Map<String, Double> revenueAndProfit = salesRepository.getTotalRevenueAndProfitForYear(year);
//////
//////        if (!revenueAndProfit.containsKey("totalRevenue")) {
//////            revenueAndProfit.put("totalRevenue", 0.0);
//////        }
//////        if (!revenueAndProfit.containsKey("totalProfit")) {
//////            revenueAndProfit.put("totalProfit", 0.0);
//////        }
//////
//////        response.setContentType("text/csv");
//////        response.setHeader("Content-Disposition", "attachment; filename=\"yearly-report.csv\"");
//////
//////        PrintWriter writer = response.getWriter();
//////        CsvGenerator.generateYearlyCsv(revenueAndProfit, writer);
//////
//////        writer.close();
//////    }
//////
//////    private String getStartDateOfMonth(String endDate) {
//////        return "01-" + endDate.substring(3); // Assuming date format is dd-mm-yyyy
//////    }
//////
//////    private String getEndDateOfMonth(String month, String year) {
//////        int monthInt = Integer.parseInt(month);
//////        int yearInt = Integer.parseInt(year);
//////        int lastDay = java.time.YearMonth.of(yearInt, monthInt).lengthOfMonth();
//////        return lastDay + "-" + month + "-" + year;
//////    }
//////}

import com.medical.management.system.medical.management.entity.Dates;
import com.medical.management.system.medical.management.repository.SalesRepository;
import com.medical.management.system.medical.management.service.CsvGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class SalesReportController {

    @Autowired
    private SalesRepository salesRepository;

    @PostMapping("/daily-report")
    public void getDailyReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
        String date = dateRequest.getDate();
        double totalRevenue = salesRepository.getTotalRevenueAndProfitForDate(date);
        double totalProfit = salesRepository.getTotalRevenueAndProfitForDate(date);
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"daily-report.csv\"");

        PrintWriter writer = response.getWriter();
        CsvGenerator.generateDailyCsv(totalRevenue, totalProfit, writer);

        writer.close();
    }

    @PostMapping("/mtd-report")
    public void getMTDReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
        String endDate = dateRequest.getDate();
        String startDate = getStartDateOfMonth(endDate);
        Map<String, Double> revenueAndProfit = salesRepository.getTotalRevenueAndProfitForDateRange(startDate, endDate);
        double totalRevenue = revenueAndProfit.getOrDefault("totalRevenue", 0.0);
        double totalProfit = revenueAndProfit.getOrDefault("totalProfit", 0.0);
        double profitPercentage = calculateProfitPercentage(totalRevenue, totalProfit);
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"mtd-report.csv\"");

        PrintWriter writer = response.getWriter();
        CsvGenerator.generateMTDCsv(revenueAndProfit, profitPercentage, writer);

        writer.close();
    }

    @PostMapping("/eom-report")
    public void getEOMReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
        String[] dateParts = dateRequest.getDate().split("-");
        if (dateParts.length != 3) {
            throw new IllegalArgumentException("Invalid date format, expected format: dd-mm-yyyy");
        }
        String month = dateParts[1];
        String year = dateParts[2];

        String startDate = "01-" + month + "-" + year;
        String endDate = getEndDateOfMonth(month, year);

        Map<String, Double> revenueAndProfit = salesRepository.getTotalRevenueAndProfitForDateRange(startDate, endDate);

        double totalRevenue = revenueAndProfit.getOrDefault("totalRevenue", 0.0);
        double totalProfit = revenueAndProfit.getOrDefault("totalProfit", 0.0);
        double profitPercentage = calculateProfitPercentage(totalRevenue, totalProfit);

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"eom-report.csv\"");

        PrintWriter writer = response.getWriter();
        CsvGenerator.generateEOMCsv(revenueAndProfit, profitPercentage, writer);

        writer.close();
    }

    private String getStartDateOfMonth(String endDate) {
        return "01-" + endDate.substring(3); // Assuming date format is dd-mm-yyyy
    }

    private String getEndDateOfMonth(String month, String year) {
        int monthInt = Integer.parseInt(month);
        int yearInt = Integer.parseInt(year);
        int lastDay = java.time.YearMonth.of(yearInt, monthInt).lengthOfMonth();
        return lastDay + "-" + month + "-" + year;
    }

    private double calculateProfitPercentage(double totalRevenue, double totalProfit) {
        if (totalRevenue == 0) {
            return 0.0;
        }
        return (totalProfit / totalRevenue) * 100;
    }
}
//@RestController
//@RequestMapping("/reports")
//public class SalesReportController {
//    @Autowired
//    private MedicineService medicineService;
//    @PostMapping("/daily")
//    public ResponseEntity<Map<String, Double>> getDailyRevenueAndProfit(@RequestBody Dates dateRequest) {
//        Map<String, Double> revenueAndProfit = medicineService.getDailyRevenueAndProfit(dateRequest.getDate());
//        return ResponseEntity.ok(revenueAndProfit);
//    }
//}
