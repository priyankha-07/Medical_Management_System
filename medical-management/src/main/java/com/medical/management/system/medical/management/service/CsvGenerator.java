package com.medical.management.system.medical.management.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class CsvGenerator {

    public static void generateDailyCsv(Double totalRevenue, Double totalProfit, PrintWriter writer) throws IOException {
        writer.println("Total Revenue," + totalRevenue);
        writer.println("Total Profit," + totalProfit);
        writer.println("Profit Percentage," + totalProfit);
        writer.flush();
    }

    public static void generateMTDCsv(Map<String, Double> revenueAndProfit, Double profitPercentage, PrintWriter writer) throws IOException {
        writer.println("Total Revenue," + revenueAndProfit.get("totalRevenue"));
        writer.println("Total Profit," + revenueAndProfit.get("totalProfit"));
        writer.println("Profit Percentage," + profitPercentage);
        writer.flush();
    }

    public static void generateEOMCsv(Map<String, Double> revenueAndProfit, Double profitPercentage, PrintWriter writer) throws IOException {
        writer.println("Total Revenue," + revenueAndProfit.get("totalRevenue"));
        writer.println("Total Profit," + revenueAndProfit.get("totalProfit"));
        writer.println("Profit Percentage," + profitPercentage);
        writer.flush();
    }
}
