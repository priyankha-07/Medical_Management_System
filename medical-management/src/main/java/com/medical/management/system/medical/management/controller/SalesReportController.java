package com.medical.management.system.medical.management.controller;

import com.medical.management.system.medical.management.entity.Dates;
import com.medical.management.system.medical.management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
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
    public void getEOMReport(@RequestBody Dates dateRequest, HttpServletResponse response) throws IOException {
        String endDate = dateRequest.getDate();
        String startDate = getStartDateOfMonth(endDate);
        Map<String, Double> revenueAndProfit = salesRepository.getTotalRevenueAndProfitForDateRange(startDate, endDate);
        double totalRevenue = revenueAndProfit.getOrDefault("totalRevenue", 0.0);

        double totalProfit = revenueAndProfit.getOrDefault("totalProfit", 0.0);
        double profitPercentage = calculateProfitPercentage(totalRevenue, totalProfit);
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"eom-report.csv\"");

        PrintWriter writer = response.getWriter();
        CsvGenerator.generateMTDCsv(revenueAndProfit, profitPercentage, writer);

        writer.close();
    }





    private String getStartDateOfMonth(String endDate) {
        return "01-" + endDate.substring(3);
    }

    private double calculateProfitPercentage(double totalRevenue, double totalProfit) {
        if (totalRevenue == 0) {
            return 0.0;
        }
        return (totalProfit / totalRevenue) * 100;
    }
}
