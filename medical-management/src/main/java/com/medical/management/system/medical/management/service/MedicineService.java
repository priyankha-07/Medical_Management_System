
package com.medical.management.system.medical.management.service;

import com.medical.management.system.medical.management.entity.*;
import com.medical.management.system.medical.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String addUserInfo(UserDetailsEntity userDetailsEntity) {
        try {
            userDetailsEntity.setPassword(passwordEncoder.encode(userDetailsEntity.getPassword()));
            userEntityRepository.save(userDetailsEntity);
            return "User added to database";
        } catch (Exception e) {
            throw new RuntimeException("Error adding user information: " + e.getMessage(), e);
        }
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

public List<MedicineEntity> getMedicineByCategory(String category) {
    List<MedicineEntity> medicines = medicineRepository.findByCategory(category);
    if (medicines.isEmpty()) {
        throw new RuntimeException("No medicines found for category " + category);
    }
    return medicines;
}

public List<MedicineEntity> getMedicineByType(String type) {
    List<MedicineEntity> medicines = medicineRepository.findByType(type);
    if (medicines.isEmpty()) {
        throw new RuntimeException("No medicines found for type " + type);
    }
    return medicines;
}
public AdminEntity getAdminDetailsById(int id) {
    Optional<AdminEntity> adminOptional = adminRepository.findById(id);
    if (adminOptional.isEmpty()) {
        throw new RuntimeException("Admin with ID " + id + " not found");
    }
    return adminOptional.get();
}


    public EmployeeEntity getEmployeeDetailById(int id) {
            Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("employee with ID " + id + " not found");
        }
        return employeeOptional.get();
    }


    public MedicineEntity getMedicineDetailsById(int id) {
        Optional<MedicineEntity> medicineOptional = medicineRepository.findById(id);
        if (medicineOptional.isEmpty()) {
            throw new RuntimeException("medicine with ID " + id + " not found");
        }
        return medicineOptional.get();
    }


    public RestockEntity getRestockDetailsById(int id) {
        Optional<RestockEntity> restockOptional = restockRepository.findById(id);
        if (restockOptional.isEmpty()) {
            throw new RuntimeException("restock with ID " + id + " not found");
        }
        return restockOptional.get();
    }

    public SalesEntity getSalesDetailById(int id) {
        Optional<SalesEntity> salesOptional = salesRepository.findById(id);
        if (salesOptional.isEmpty()) {
            throw new RuntimeException("sales with ID " + id + " not found");
        }
        return salesOptional.get();
    }


public AdminEntity getAdminDetailByName(String name) {
    Optional<AdminEntity> adminOptional =adminRepository.findByName(name);
    if (adminOptional.isEmpty()) {
        throw new RuntimeException("admin with name " + name + " not found");
    }
    return adminOptional.get();
}

    public EmployeeEntity getEmployeeByName(String name) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findByName(name);
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("employee with name " + name + " not found");
        }
        return employeeOptional.get();
    }

    public MedicineEntity getMedicineByName(String name) {

        Optional<MedicineEntity> medicineOptional = medicineRepository.findByName(name);
        if (medicineOptional.isEmpty()) {
            throw new RuntimeException("medicine with name " + name + " not found");
        }
        return medicineOptional.get();
    }

    public List<AdminEntity> saveAllAdmins(List<AdminEntity> admins) {
        try {
            return adminRepository.saveAll(admins);
        } catch (Exception e) {
            throw new RuntimeException("Error saving admins: " + e.getMessage());
        }
    }

    public List<EmployeeEntity> saveAllEmployees(List<EmployeeEntity> employees) {
        try {
            return employeeRepository.saveAll(employees);
        } catch (Exception e) {
            throw new RuntimeException("Error saving employees: " + e.getMessage());
        }
    }

    public List<MedicineEntity> saveAllMedicinesAsList(List<MedicineEntity> medicines) {
        try {
            return medicineRepository.saveAll(medicines);
        } catch (Exception e) {
            throw new RuntimeException("Error saving medicines: " + e.getMessage());
        }
    }

    public List<RestockEntity> saveAllRestocDetails(List<RestockEntity> restock) {
        try {
            for (RestockEntity r : restock) {
                validateMedicineExists(r.getMedicineId());
            }
            return restockRepository.saveAll(restock);
        } catch (Exception e) {
            throw new RuntimeException("Error saving restocks: " + e.getMessage());
        }
    }

    public List<SalesEntity> saveAllDetailsOfSales(List<SalesEntity> salesEntityList) {
        try {
            for (SalesEntity s : salesEntityList) {
                validateMedicineExists(s.getMedicineId());
            }
            return salesRepository.saveAll(salesEntityList);
        } catch (Exception e) {
            throw new RuntimeException("Error saving sales: " + e.getMessage());
        }
    }

    public AdminEntity saveAdminDetail(AdminEntity admin) {
        try {
            return adminRepository.save(admin);
        } catch (Exception e) {
            throw new RuntimeException("Error saving admin: " + e.getMessage());
        }
    }

    public EmployeeEntity saveEmployeeDetail(EmployeeEntity employee) {
        try {
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Error saving employee: " + e.getMessage());
        }
    }

    public MedicineEntity saveMedicineDetail(MedicineEntity medicine) {
        try {
            return medicineRepository.save(medicine);
        } catch (Exception e) {
            throw new RuntimeException("Error saving medicine: " + e.getMessage());
        }
    }

    public RestockEntity saveRestockDetail(RestockEntity restockEntity) {
        try {
            validateMedicineExists(restockEntity.getMedicineId());
            return restockRepository.save(restockEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error saving restock: " + e.getMessage());
        }
    }

    public SalesEntity saveSalesDetail(SalesEntity salesEntity) {
        try {
            validateMedicineExists(salesEntity.getMedicineId());
            return salesRepository.save(salesEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error saving sales: " + e.getMessage());
        }
    }

    public AdminEntity updateAdminDetail(AdminEntity admin) {
        try {
            AdminEntity a = adminRepository.findById(admin.getId()).orElse(null);
            if (a == null) {
                throw new RuntimeException("Admin with ID " + admin.getId() + " not found");
            }
            a.setName(admin.getName());
            a.setPassword(admin.getPassword());
            a.setRoles(admin.getRoles());
            return adminRepository.save(a);
        } catch (Exception e) {
            throw new RuntimeException("Error updating admin: " + e.getMessage());
        }
    }

    public EmployeeEntity updateEmployeeDetail(EmployeeEntity employee) {
        try {
            EmployeeEntity e = employeeRepository.findById(employee.getId()).orElse(null);
            if (e == null) {
                throw new RuntimeException("Employee with ID " + employee.getId() + " not found");
            }
            e.setName(employee.getName());
            e.setPassword(employee.getPassword());
            e.setRoles(employee.getRoles());
            return employeeRepository.save(e);
        } catch (Exception e) {
            throw new RuntimeException("Error updating employee: " + e.getMessage());
        }
    }

    public MedicineEntity updateMedicineDetail(MedicineEntity medicine) {
        try {
            MedicineEntity m = medicineRepository.findById(medicine.getId()).orElse(null);
            if (m == null) {
                throw new RuntimeException("Medicine with ID " + medicine.getId() + " not found");
            }
            m.setName(medicine.getName());
            m.setCategory(medicine.getCategory());
            m.setType(medicine.getType());
            m.setQuantity(medicine.getQuantity());
            m.setPrice(medicine.getPrice());
            return medicineRepository.save(m);
        } catch (Exception e) {
            throw new RuntimeException("Error updating medicine: " + e.getMessage());
        }
    }

    public RestockEntity updateRestockDetail(RestockEntity restock) {
        try {
            RestockEntity r = restockRepository.findById(restock.getId()).orElse(null);
            if (r == null) {
                throw new RuntimeException("Restock with ID " + restock.getId() + " not found");
            }
            validateMedicineExists(restock.getMedicineId());
            r.setMedicineId(restock.getMedicineId());
            r.setQuantityRequest(restock.getQuantityRequest());
            r.setStatus(restock.getStatus());
            r.setRequestedDate(restock.getRequestedDate());
            r.setBuyingPrice(restock.getBuyingPrice());
            return restockRepository.save(r);
        } catch (Exception e) {
            throw new RuntimeException("Error updating restock: " + e.getMessage());
        }
    }

    public SalesEntity updateSalesDetail(SalesEntity sales) {
        try {
            SalesEntity s = salesRepository.findById(sales.getId()).orElse(null);
            if (s == null) {
                throw new RuntimeException("Sales with ID " + sales.getId() + " not found");
            }
            validateMedicineExists(sales.getMedicineId());
            s.setMedicineId(sales.getMedicineId());
            s.setQuantitySold(sales.getQuantitySold());
            s.setRemainingQuantity(sales.getRemainingQuantity());
            s.setSoldDate(sales.getSoldDate());
            s.setSellingPrice(sales.getSellingPrice());
            return salesRepository.save(s);
        } catch (Exception e) {
            throw new RuntimeException("Error updating sales: " + e.getMessage());
        }
    }

    public AdminEntity deleteAdminDetails(int id) {
        Optional<AdminEntity> adminOptional = adminRepository.findById(id);
        if (adminOptional.isEmpty()) {
            throw new RuntimeException("admin with id " + id + " not found");
        }
        return adminOptional.get();
    }


    public EmployeeEntity deleteEmployeeDetails(int id) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("employee with id " + id + " not found");
        }
        return employeeOptional.get();
    }


    public MedicineEntity deleteMedicineDetails(int id) {
        Optional<MedicineEntity> medicineOptional = medicineRepository.findById(id);
        if (medicineOptional.isEmpty()) {
            throw new RuntimeException("medicine with id " + id + " not found");
        }
        return medicineOptional.get();
    }


    public RestockEntity deleteRestockDetails(int id) {
        Optional<RestockEntity> restockOptional = restockRepository.findById(id);
        if (restockOptional.isEmpty()) {
            throw new RuntimeException("restock with id " + id + " not found");
        }
        return restockOptional.get();
    }


    public SalesEntity deleteSalesDetails(int id) {
        Optional<SalesEntity> salesOptional = salesRepository.findById(id);
        if (salesOptional.isEmpty()) {
            throw new RuntimeException("sales with id " + id + " not found");
        }
        return salesOptional.get();
    }


    private void validateMedicineExists(int medicineId) {
        if (!medicineRepository.existsById(medicineId)) {
            throw new RuntimeException("Medicine with ID " + medicineId + " does not exist");
        }
    }
}
