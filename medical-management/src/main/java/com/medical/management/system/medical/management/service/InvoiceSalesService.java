package com.medical.management.system.medical.management.service;

import com.medical.management.system.medical.management.entity.SalesEntity;
import com.medical.management.system.medical.management.repository.MedicineRepository;
import com.medical.management.system.medical.management.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceSalesService {
    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private SalesRepository salesRepository;

    public String generateSalesInvoice(int salesId) {
        SalesEntity salesEntity = salesRepository.findById(salesId).orElseThrow(() -> new RuntimeException("Sales record not found"));

        double totalAmount = salesEntity.getSellingPrice() * salesEntity.getQuantitySold();

        StringBuilder invoice = new StringBuilder();
        invoice.append("Sales Invoice\n");
        invoice.append("Medicine ID: ").append(salesEntity.getMedicineId()).append("\n");
        invoice.append("Quantity Sold: ").append(salesEntity.getQuantitySold()).append("\n");
        invoice.append("Selling Price: ").append(salesEntity.getSellingPrice()).append("\n");
        invoice.append("Total Amount: ").append(totalAmount).append("\n");
        invoice.append("Sold Date: ").append(salesEntity.getSoldDate()).append("\n");

        return invoice.toString();
    }
}
