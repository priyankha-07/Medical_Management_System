package com.medical.management.system.medical.management.controller;

import com.medical.management.system.medical.management.entity.Dates;
import com.medical.management.system.medical.management.entity.RevenueProfitDTO;
import com.medical.management.system.medical.management.entity.SalesEntity;
import com.medical.management.system.medical.management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
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

import com.medical.management.system.medical.management.repository.SalesRepository;
import com.medical.management.system.medical.management.service.CsvGenerator;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/reports")
public class SalesReportController {

    @Autowired
    private SalesRepository salesRepository;
    @Autowired
  private  MedicineService medicineService;

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

    public RevenueProfitDTO getMonthlyReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
        String year = dateRequest.getYear();
        String month = dateRequest.getMonth();

        RevenueProfitDTO result = (RevenueProfitDTO) salesRepository.findByMonthAndYear("6", "2024");
        double totalRevenue = result.getTotalRevenue();
        double totalProfit = result.getTotalProfit();
        double profitPercentage = calculateProfitPercentage(totalRevenue, totalProfit);
        return  result;

//        response.setContentType("text/csv");
//        response.setHeader("Content-Disposition", "attachment; filename=\"monthly-report.csv\"");
//
//        PrintWriter writer = response.getWriter();
//        CsvGenerator.generateEOMCsv(result, profitPercentage, writer);
//
//        writer.close();
    }

//@PostMapping("/revenue-profit")
//public Map<String, Object> getRevenueAndProfit(@RequestBody Dates dateRequest) {
//    String year = dateRequest.getYear();
//    String month = dateRequest.getMonth();
//    String yearMonth = year + "-" + String.format("%02d", Integer.parseInt(month));
//    Object[] results = salesRepository.getRevenueAndProfitPercentage(yearMonth);
//
//    Map<String, Object> response = new HashMap<>();
//
//    if (results != null && results.length == 2) {
//        response.put("totalRevenue", results[0] != null ? results[0] : 0);
//        response.put("profitPercentage", results[1] != null ? results[1] : 0);
//    } else {
//        response.put("totalRevenue", 0);
//        response.put("profitPercentage", 0);
//    }
//
//    return response;
//}
//

//@PostMapping("/eom-report")
//public void getEOMReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
//    String[] dateParts = dateRequest.getDate().split("-");
//    String month = dateParts[0];
//    String year = dateParts[1];
//
//  //  Map<String, Double> revenueAndProfit = salesRepository.findByMonthAndYear(date);
//    double totalRevenue = revenueAndProfit.getOrDefault("totalRevenue", 0.0);
//    double totalProfit = revenueAndProfit.getOrDefault("totalProfit", 0.0);
//    double profitPercentage = (totalRevenue == 0) ? 0 : (totalProfit / totalRevenue) * 100;
//
//    response.setHeader("Content-Type", "text/csv");
//    response.setHeader("Content-Disposition", "attachment; filename=\"eom-report.csv\"");
//    PrintWriter writer = response.getWriter();
//    CsvGenerator.generateEOMCsv(revenueAndProfit,profitPercentage, writer);
//}



//    @PostMapping("/eom-report")
//
//    public void getEOMReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
//        Map<String, Double> result = salesRepository.findByMonthAndYear(month, year);
//
//        double totalRevenue = result.getOrDefault("totalRevenue", 0.0);
//        double totalProfit = result.getOrDefault("totalProfit", 0.0);
//
//        double profitPercentage = (totalRevenue == 0) ? 0 : (totalProfit / totalRevenue) * 100;
//
//        result.put("profitPercentage", profitPercentage);
//
//        return result;
//    }
//@PostMapping("/eom-report")
//public void getEOMReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
//    // Extract month and year from dateRequest
//    String[] dateParts = dateRequest.getDate().split("-");
//    if (dateParts.length != 3) {
//        throw new IllegalArgumentException("Invalid date format, expected format: dd-mm-yyyy");
//    }
//    int month = Integer.parseInt(dateParts[1]);
//    int year = Integer.parseInt(dateParts[2]);
//
//    // Retrieve the revenue and profit data from the repository
//    Map<String, Double> revenueAndProfit = salesRepository.findByMonthAndYear(month, year);
//
//    // Safely get the totalRevenue and totalProfit from the map
//    double totalRevenue = revenueAndProfit.getOrDefault("totalRevenue", 0.0);
//    double totalProfit = revenueAndProfit.getOrDefault("totalProfit", 0.0);
//
//    // Calculate the profit percentage
//    double profitPercentage = (totalRevenue == 0) ? 0 : (totalProfit / totalRevenue) * 100;
//
//    // Set the response headers for CSV file download
//    response.setContentType("text/csv");
//    response.setHeader("Content-Disposition", "attachment; filename=\"eom-report.csv\"");
//
//    // Write the CSV content to the response writer
//    try (PrintWriter writer = response.getWriter()) {
//        writer.println("Total Revenue," + totalRevenue);
//        writer.println("Total Profit," + totalProfit);
//        writer.println("Profit Percentage," + profitPercentage);
//        writer.flush();
//    }




    //@PostMapping("/eom-report")
//public void getEOMReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
//    // Split the date string and validate its format
//    String[] dateParts = dateRequest.getDate().split("-");
//    if (dateParts.length != 3) {
//        throw new IllegalArgumentException("Invalid date format, expected format: dd-mm-yyyy");
//    }
//    String month = dateParts[1];
//    String year = dateParts[2];
//
//    // Retrieve the revenue and profit data from the repository
//    Map<String, Double> revenueAndProfit = salesRepository.findByMonthAndYear(Integer.parseInt(month), Integer.parseInt(year));
//
//    // Safely get the totalRevenue and totalProfit from the map
//    double totalRevenue = revenueAndProfit.getOrDefault("totalRevenue", 0.0);
//    double totalProfit = revenueAndProfit.getOrDefault("totalProfit", 0.0);
//
//    // Calculate the profit percentage
//    double profitPercentage = (totalRevenue == 0) ? 0 : (totalProfit / totalRevenue) * 100;
//
//    // Set the response headers for CSV file download
//    response.setHeader("Content-Type", "text/csv");
//    response.setHeader("Content-Disposition", "attachment; filename=\"eom-report.csv\"");
//
//    // Write the CSV content to the response writer
//    try (PrintWriter writer = response.getWriter()) {
//        CsvGenerator.generateEOMCsv(revenueAndProfit, profitPercentage, writer);
//    }
//}
    private String getStartDateOfMonth(String endDate) {
        return "01-" + endDate.substring(3); // Assuming date format is dd-mm-yyyy
    }

    private double calculateProfitPercentage(double totalRevenue, double totalProfit) {
        if (totalRevenue == 0) {
            return 0.0;
        }
        return (totalProfit / totalRevenue) * 100;
    }
}
