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
@Table(name="restock_request")
public class RestockEntity {
  @Id
  @GeneratedValue
  private  int id;
  private  int medicineId;
  private  int quantityRequest;
  private  String status;
  private  String requestedDate;
  private  double buyingPrice;

}
