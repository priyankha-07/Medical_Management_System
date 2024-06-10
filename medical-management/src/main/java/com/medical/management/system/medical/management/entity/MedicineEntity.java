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
@Table(name = "medicines_info")
public class MedicineEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String category;
    private String type;
    private int quantity;
    private double price;
}
