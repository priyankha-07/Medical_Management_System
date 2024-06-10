package com.medical.management.system.medical.management.controller;

import com.medical.management.system.medical.management.entity.*;
import com.medical.management.system.medical.management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacy")
public class MedicineController
{
    @Autowired
    private MedicineService service;

// add details as individual

    @PostMapping("/add/adminInfo")
    public AdminEntity addDetailsOfAdmin(@RequestBody AdminEntity adminEntity){
        return service.saveAdminDetail(adminEntity);
    }

    @PostMapping("/add/employeeInfo")
    public EmployeeEntity addDetailsOfEmployee(@RequestBody EmployeeEntity employeeEntity){
        return service.saveEmployeeDetail(employeeEntity);
    }

    @PostMapping("/add/medicineInfo")
    public MedicineEntity addDetailsOfMedicine(@RequestBody MedicineEntity medicineEntity){
        return service.saveMedicineDetail(medicineEntity);
    }

    @PostMapping("/add/restockInfo")
    public RestockEntity addDetailsOfRestock(@RequestBody RestockEntity restockEntity){
        return service.saveRestockDetail(restockEntity);
    }

    @PostMapping("/add/salesInfo")
    public SalesEntity addDetailsOfSales(@RequestBody SalesEntity salesEntity){
        return service.saveSalesDetail(salesEntity);
    }

    // Add Details as List

    @PostMapping("/add/ListOfAdmins")
    public List<AdminEntity> addAdminDetails(@RequestBody List<AdminEntity> admins) {
        return service.saveAllAdmins(admins);
    }
    @PostMapping("/add/ListOfEmployees")
    public List<EmployeeEntity> addEmployeeDetails(@RequestBody List<EmployeeEntity> employees) {
        return service.saveAllEmployees(employees);
    }
    @PostMapping("/add/ListOfMedicines")
    public List<MedicineEntity> addMedicineDetails(@RequestBody List<MedicineEntity> medicines) {
        return service.saveAllMedicinesAsList(medicines);
    }
    @PostMapping("/add/ListOfRestocks")
    public List<RestockEntity> addRestockDetails(@RequestBody List<RestockEntity> restockEntities) {
        return service.saveAllRestocDetails(restockEntities);
    }
    @PostMapping("/add/ListOfSales")
    public List<SalesEntity> addSalesDetails(@RequestBody List<SalesEntity> salesEntities) {
        return service.saveAllDetailsOfSales(salesEntities);
    }

    // Get Details As List
    @GetMapping("/display/AllAdmins")
    public List<AdminEntity> findAllAdminDetails() {
        return service.getAllAdminsInfo();
    }

    @GetMapping("/display/AllEmployees")
    public List<EmployeeEntity> findAllEmployeeDetails() {
        return service.getAllEmployeesInfo();
    }

    @GetMapping("/display/AllMedicines")
    public List<MedicineEntity> findAllMedicineDetails() {
        return service.getAllMedicinesInfo();
    }
    @GetMapping("/display/AllRestocks")
    public List<RestockEntity> findAllRestockDetails() {
        return service.getAllDetailsOfRestock();
    }
    @GetMapping("/display/AllSales")
    public List<SalesEntity> findAllSalesDetails() {
        return service.getAllDetailsOfSales();
    }

//GET DETAILS BY ID
    @GetMapping("/display/AdminById/{id}")
     public AdminEntity findAdminById(@PathVariable int id) {
        return service.getAdminDetailsById(id);
   }
    @GetMapping("/display/EmployeeById/{id}")
    public EmployeeEntity findEmployeeById(@PathVariable int id) {
        return service.getEmployeeDetailById(id);
    }
    @GetMapping("/display/MedicineById/{id}")
    public MedicineEntity findMedicineById(@PathVariable int id) {
        return service.getMedicineDetailsById(id);
    }
    @GetMapping("/display/RestockById/{id}")
    public RestockEntity findRestockById(@PathVariable int id) {
        return service.getRestockDetailsById(id);
    }
    @GetMapping("/display/SalesById/{id}")
    public SalesEntity findSalesById(@PathVariable int id) {
        return service.getSalesDetailById(id);
    }

//Get Details By Name

    @GetMapping("/display/AdminDetailsByName/{name}")
    public AdminEntity findAdminByName(@PathVariable String name) {
        return service.getAdminByName(name);
    }
    @GetMapping("/display/EmployeeDetailsByName/{name}")
    public EmployeeEntity findEmployeeByName(@PathVariable String name) {
        return service.getEmployeeByName(name);
    }
    @GetMapping("/display/MedicineDetailsByName/{name}")
    public MedicineEntity findMedicineByName(@PathVariable String name) {
        return service.getMedicineByName(name);
    }

//update

    @PutMapping("/update/Admin")
    public AdminEntity updateAdminDetails(@RequestBody AdminEntity admin) {
        return service. updateAdminDetail(admin);
    }
    @PutMapping("/update/Employee")
    public EmployeeEntity updateEmployeeDetails(@RequestBody EmployeeEntity employee) {
        return service. updateEmployeeDetail(employee);
    }
    @PutMapping("/update/Medicine")
    public MedicineEntity updateMedicineDetails(@RequestBody MedicineEntity medicine) {
        return service. updateMedicineDetail(medicine);
    }
    @PutMapping("/update/Restock")
    public RestockEntity updateRestockDetails(@RequestBody RestockEntity restock) {
        return service. updateRestockDetail(restock);
    }
    @PutMapping("/update/Sales")
    public SalesEntity updateSalesDetails(@RequestBody SalesEntity sales) {
        return service. updateSalesDetail(sales);
    }

   //delete
    @DeleteMapping("/delete/Admins/{id}")
    public String deleteAdminDtailById(@PathVariable int id){
        service.deleteAdminDetails(id);
        return "Successfully deleted";
    }
    @DeleteMapping("/delete/Employee/{id}")
    public String deleteEmployeeDtailById(@PathVariable int id){
        service.deleteEmployeeDetails(id);
        return "Successfully deleted";
    }
    @DeleteMapping("/delete/Medicine/{id}")
    public String deleteMedicineDetailById(@PathVariable int id){
        service.deleteMedicineDetails(id);
        return "Successfully deleted";
    }
    @DeleteMapping("/delete/Restock/{id}")
    public String deleteRestockDetailById(@PathVariable int id){
        service.deleteRestockDetails(id);
        return "Successfully deleted";
    }
    @DeleteMapping("/delete/Sales/{id}")
    public String deleteSalesDetailById(@PathVariable int id){
        service.deleteSalesDetails(id);
        return "Successfully deleted";
    }

}
