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
//
//    public static void generateEOMCsv(Map<String, Double> revenueAndProfit, Double profitPercentage, PrintWriter writer) throws IOException {
//        writer.println("Total Revenue," + revenueAndProfit.get("totalRevenue"));
//        writer.println("Total Profit," + revenueAndProfit.get("totalProfit"));
//        writer.println("Profit Percentage," + profitPercentage);
//        writer.flush();
//    }

//////public static String generateEOMCsv(Map<String, Double> revenueAndProfit, Double profitPercentage, PrintWriter writer) {
//////        StringBuilder sb = new StringBuilder();
//////        sb.append("Total Revenue,").append(revenueAndProfit.get("totalRevenue")).append("\n");
//////        sb.append("Total Profit,").append(revenueAndProfit.get("totalProfit")).append("\n");
//////        sb.append("Profit Percentage,").append(profitPercentage);
//////        return sb.toString();
//   }



public static void generateEOMCsv(Map<String, Double> revenueAndProfit, double profitPercentage, PrintWriter writer) throws IOException {
    // Ensure revenueAndProfit contains non-null values for the required keys
    double totalRevenue = revenueAndProfit.getOrDefault("totalRevenue", 0.0);
    double totalProfit = revenueAndProfit.getOrDefault("totalProfit", 0.0);

    // Write CSV data
    writer.println("Total Revenue," + totalRevenue);
    writer.println("Total Profit," + totalProfit);
    writer.println("Profit Percentage," + profitPercentage);
    writer.flush();
}



}
