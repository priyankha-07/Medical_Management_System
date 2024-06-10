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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="admin")
public class AdminEntity {
   @Id
   @GeneratedValue
   private int id;
   private String name;
   private String roles;
   private String password;
}
