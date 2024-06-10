package com.medical.management.system.medical.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
