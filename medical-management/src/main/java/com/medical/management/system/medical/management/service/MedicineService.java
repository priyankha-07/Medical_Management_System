

package com.medical.management.system.medical.management.service;

import com.medical.management.system.medical.management.entity.*;
import com.medical.management.system.medical.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private RestockRepository restockRepository;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private UserDetailsRepository userEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUserInfo(UserDetailsEntity userDetailsEntity){
        userDetailsEntity. setPassword(passwordEncoder.encode(userDetailsEntity.getPassword()));
        userEntityRepository.save(userDetailsEntity);
        return "user added to database";
    }
    public List<AdminEntity> getAllAdminsInfo() {
        return adminRepository.findAll();
    }

    public List<EmployeeEntity> getAllEmployeesInfo() {
        return employeeRepository.findAll();
    }

    public List<MedicineEntity> getAllMedicinesInfo() {
        return medicineRepository.findAll();
    }

    public List<RestockEntity> getAllDetailsOfRestock() {
        return restockRepository.findAll();
    }

    public List<SalesEntity> getAllDetailsOfSales() {
        return salesRepository.findAll();
    }


    public AdminEntity getAdminDetailsById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    public EmployeeEntity getEmployeeDetailById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public MedicineEntity getMedicineDetailsById(int id) {
        return medicineRepository.findById(id).orElse(null);
    }

    public RestockEntity getRestockDetailsById(int id) {
        return restockRepository.findById(id).orElse(null);
    }

    public SalesEntity getSalesDetailById(int id) {
        return salesRepository.findById(id).orElse(null);
    }

    // Get individual details by name

    public AdminEntity getAdminByName(String name) {
        return adminRepository.findByName(name);
    }

    public EmployeeEntity getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public MedicineEntity getMedicineByName(String name) {
        return medicineRepository.findByName(name);
    }


    public List<AdminEntity> saveAllAdmins(List<AdminEntity> admins) {
        return adminRepository.saveAll(admins);
    }

    public List<EmployeeEntity> saveAllEmployees(List<EmployeeEntity> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<MedicineEntity> saveAllMedicinesAsList(List<MedicineEntity> medicines) {
        return medicineRepository.saveAll(medicines);
    }

    public List<RestockEntity> saveAllRestocDetails(List<RestockEntity> restock) {
        for (RestockEntity r : restock) {
            validateMedicineExists(r.getMedicineId());
        }
        return restockRepository.saveAll(restock);
    }

    public List<SalesEntity> saveAllDetailsOfSales(List<SalesEntity> salesEntityList) {
        for (SalesEntity s : salesEntityList) {
            validateMedicineExists(s.getMedicineId());
        }
        return salesRepository.saveAll(salesEntityList);
    }


    public AdminEntity saveAdminDetail(AdminEntity admin) {
        return adminRepository.save(admin);
    }

    public EmployeeEntity saveEmployeeDetail(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public MedicineEntity saveMedicineDetail(MedicineEntity medicine) {
        return medicineRepository.save(medicine);
    }

    public RestockEntity saveRestockDetail(RestockEntity restockEntity) {
        validateMedicineExists(restockEntity.getMedicineId());
        return restockRepository.save(restockEntity);
    }

    public SalesEntity saveSalesDetail(SalesEntity salesEntity) {
        validateMedicineExists(salesEntity.getMedicineId());
        return salesRepository.save(salesEntity);
    }

    // Update
//    public UserDetailsEntity updateUserDetail(UserEntity user) {
//        UserEntity u = userEntityRepository.findById(user.getId()).orElse(null);
//        u.setName(user.getName());
//        u.setPassword(user.getPassword());
//        u.setRoles(user.getRoles());
//        return userEntityRepository.save(u);
//    }
    public AdminEntity updateAdminDetail(AdminEntity admin) {
        AdminEntity a = adminRepository.findById(admin.getId()).orElse(null);
        a.setName(admin.getName());
        a.setPassword(admin.getPassword());
        a.setRoles(admin.getRoles());
        return adminRepository.save(a);
    }

    public EmployeeEntity updateEmployeeDetail(EmployeeEntity employee) {
        EmployeeEntity e = employeeRepository.findById(employee.getId()).orElse(null);
        e.setName(employee.getName());
        e.setPassword(employee.getPassword());
        e.setRoles(employee.getRoles());
        return employeeRepository.save(e);
    }

    public MedicineEntity updateMedicineDetail(MedicineEntity medicine) {
        MedicineEntity m = medicineRepository.findById(medicine.getId()).orElse(null);
        m.setName(medicine.getName());
        m.setCategory(medicine.getCategory());
        m.setType(medicine.getType());
        m.setQuantity(medicine.getQuantity());
        m.setPrice(medicine.getPrice());
        return medicineRepository.save(m);
    }

    public RestockEntity updateRestockDetail(RestockEntity restock) {
        RestockEntity r = restockRepository.findById(restock.getId()).orElse(null);
        validateMedicineExists(restock.getMedicineId());
        r.setMedicineId(restock.getMedicineId());
        r.setQuantityRequest(restock.getQuantityRequest());
        r.setStatus(restock.getStatus());
        r.setRequestedDate(restock.getRequestedDate());
        r.setBuyingPrice(restock.getBuyingPrice());
        return restockRepository.save(r);
    }

    public SalesEntity updateSalesDetail(SalesEntity sales) {
        SalesEntity s = salesRepository.findById(sales.getId()).orElse(null);
        validateMedicineExists(sales.getMedicineId());
        s.setMedicineId(sales.getMedicineId());
        s.setQuantitySold(sales.getQuantitySold());
        s.setRemainingQuantity(sales.getRemainingQuantity());
        s.setSoldDate(sales.getSoldDate());
        s.setSellingPrice(sales.getSellingPrice());
        return salesRepository.save(s);
    }

    // Delete
    public String deleteAdminDetails(int id) {
        adminRepository.deleteById(id);
        return "Successfully deleted " + id;
    }

    public String deleteEmployeeDetails(int id) {
        employeeRepository.deleteById(id);
        return "Successfully deleted " + id;
    }

    public String deleteMedicineDetails(int id) {
        medicineRepository.deleteById(id);
        return "Successfully deleted " + id;
    }

    public String deleteRestockDetails(int id) {
        restockRepository.deleteById(id);
        return "Successfully deleted " + id;
    }

    public String deleteSalesDetails(int id) {
        salesRepository.deleteById(id);
        return "Successfully deleted " + id;
    }

    private void validateMedicineExists(int medicineId) {
        if (!medicineRepository.existsById(medicineId)) {
            throw new RuntimeException("Medicine with ID " + medicineId + " does not exist");
        }
    }
}
