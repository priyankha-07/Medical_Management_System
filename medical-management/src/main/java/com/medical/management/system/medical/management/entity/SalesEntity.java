package com.medical.management.system.medical.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sales_info")
public class SalesEntity {
    @Id
    @GeneratedValue
    private int id;
    private int medicineId;
    private int quantitySold;
    private int remainingQuantity;
    private String soldDate;
    private double sellingPrice;
    private double totalAmount;
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
