package com.medical.management.system.medical.management.service;

import com.medical.management.system.medical.management.entity.RestockEntity;
import com.medical.management.system.medical.management.entity.SalesEntity;
import com.medical.management.system.medical.management.repository.MedicineRepository;
import com.medical.management.system.medical.management.repository.RestockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceRestockService {
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private RestockRepository restockRepository;

    public String generateRestockInvoice(int salesId) {
        RestockEntity restockEntity = restockRepository.findById(salesId).orElseThrow(() -> new RuntimeException("stock record not found"));

        double totalAmount = restockEntity.getBuyingPrice() * restockEntity.getQuantityRequest();

        StringBuilder invoice = new StringBuilder();
        invoice.append("Restock Invoice\n");
        invoice.append("Medicine ID: ").append(restockEntity.getMedicineId()).append("\n");
        invoice.append("Quantity Requested: ").append(restockEntity.getQuantityRequest()).append("\n");
        invoice.append("Buying Price: ").append(restockEntity.getBuyingPrice()).append("\n");
        invoice.append("status: ").append(restockEntity.getStatus()).append("\n");
        invoice.append("Total Amount: ").append(totalAmount).append("\n");
        invoice.append("Requested Date: ").append(restockEntity.getRequestedDate()).append("\n");

        return invoice.toString();
    }
}


