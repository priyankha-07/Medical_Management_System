//package com.medical.management.system.medical.management.service;
//
//import com.medical.management.system.medical.management.entity.RestockEntity;
//import com.medical.management.system.medical.management.repository.MedicineRepository;
//import com.medical.management.system.medical.management.repository.RestockRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class InvoiceRestockService {
//    @Autowired
//    private MedicineRepository medicineRepository;
//    @Autowired
//    private RestockRepository restockRepository;
//
//    public String generateRestockInvoice(int salesId) {
//        RestockEntity restockEntity = restockRepository.findById(salesId)
//                .orElseThrow(() -> new RuntimeException("Stock record not found"));
//
//        double totalAmount = restockEntity.getBuyingPrice() * restockEntity.getQuantityRequest();
//
//        // Manually construct JSON string with line breaks and indentation
//        StringBuilder invoice = new StringBuilder();
//        invoice.append("{\n");
//        invoice.append("    \"Medicine ID\": ").append(restockEntity.getMedicineId()).append(",\n");
//        invoice.append("    \"Quantity Requested\": ").append(restockEntity.getQuantityRequest()).append(",\n");
//        invoice.append("    \"Buying Price\": ").append(restockEntity.getBuyingPrice()).append(",\n");
//        invoice.append("    \"Status\": \"").append(restockEntity.getStatus()).append("\",\n");
//        invoice.append("    \"Total Amount\": ").append(totalAmount).append(",\n");
//        invoice.append("    \"Requested Date\": \"").append(restockEntity.getRequestedDate()).append("\"\n");
//        invoice.append("}");
//
//        return invoice.toString();
//    }
//}
package com.medical.management.system.medical.management.service;

import com.medical.management.system.medical.management.entity.RestockEntity;
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
        RestockEntity restockEntity = restockRepository.findById(salesId)
                .orElseThrow(() -> new RuntimeException("Stock record not found"));

        double totalAmount = restockEntity.getBuyingPrice() * restockEntity.getQuantityRequest();

        // Update the entity with the total amount
        restockEntity.setTotalAmount(totalAmount); // Assuming there is a field for total amount

        // Save the updated entity back to the repository
        restockRepository.save(restockEntity);

        // Manually construct JSON string with line breaks and indentation
        StringBuilder invoice = new StringBuilder();
        invoice.append("{\n");
        invoice.append("    \"Medicine ID\": ").append(restockEntity.getMedicineId()).append(",\n");
        invoice.append("    \"Quantity Requested\": ").append(restockEntity.getQuantityRequest()).append(",\n");
        invoice.append("    \"Buying Price\": ").append(restockEntity.getBuyingPrice()).append(",\n");
        invoice.append("    \"Status\": \"").append(restockEntity.getStatus()).append("\",\n");
        invoice.append("    \"Total Amount\": ").append(restockEntity.getTotalAmount()).append(",\n");
        invoice.append("    \"Requested Date\": \"").append(restockEntity.getRequestedDate()).append("\"\n");
        invoice.append("}");

        return invoice.toString();
    }
}
