//package com.medical.management.system.medical.management.service;
//
//
//import com.medical.management.system.medical.management.entity.*;
//import com.medical.management.system.medical.management.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MedicineService {
//    @Autowired
//    private AdminRepository adminRepository;
//    @Autowired
//    private EmployeeRepository employeeRepository;
//    @Autowired
//    private MedicineRepository medicineRepository;
//    @Autowired
//    private RestockRepository restockRepository;
//    @Autowired
//    private SalesRepository salesRepository;
//    @Autowired
//    private UserDetailsRepository userEntityRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public String addUserInfo(UserDetailsEntity userDetailsEntity){
//        userDetailsEntity. setPassword(passwordEncoder.encode(userDetailsEntity.getPassword()));
//        userEntityRepository.save(userDetailsEntity);
//        return "user added to database";
//    }
//    public List<AdminEntity> getAllAdminsInfo() {
//        return adminRepository.findAll();
//    }
//
//    public List<EmployeeEntity> getAllEmployeesInfo() {
//        return employeeRepository.findAll();
//    }
//
//    public List<MedicineEntity> getAllMedicinesInfo() {
//        return medicineRepository.findAll();
//    }
//
//    public List<RestockEntity> getAllDetailsOfRestock() {
//        return restockRepository.findAll();
//    }
//
//    public List<SalesEntity> getAllDetailsOfSales() {
//        return salesRepository.findAll();
//    }
//
//
//public AdminEntity getAdminDetailsById(int id) {
//    Optional<AdminEntity> adminOptional = adminRepository.findById(id);
//    return adminOptional.orElseThrow(() -> new RuntimeException("Admin with ID " + id + " not found"));
//}
//
//    public EmployeeEntity getEmployeeDetailById(int id) {
//        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);
//        return employeeOptional.orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
//    }
//
//    public MedicineEntity getMedicineDetailsById(int id) {
//        Optional<MedicineEntity> medicineOptional = medicineRepository.findById(id);
//        return medicineOptional.orElseThrow(() -> new RuntimeException("Medicine with ID " + id + " not found"));
//    }
//
//    public RestockEntity getRestockDetailsById(int id) {
//        Optional<RestockEntity> restockOptional = restockRepository.findById(id);
//        return restockOptional.orElseThrow(() -> new RuntimeException("Restock with ID " + id + " not found"));
//    }
//
//
//    public SalesEntity getSalesDetailById(int id) {
//        Optional<SalesEntity> salesOptional = salesRepository.findById(id);
//        return salesOptional.orElseThrow(() -> new RuntimeException("Sales with ID " + id + " not found"));
//    }
//
//    // Get individual details by name
//
//    public AdminEntity getAdminByName(String name) {
//        return adminRepository.findByName(name);
//    }
//
//    public EmployeeEntity getEmployeeByName(String name) {
//        return employeeRepository.findByName(name);
//    }
//
//    public MedicineEntity getMedicineByName(String name) {
//        return medicineRepository.findByName(name);
//    }
//
//
//    public List<AdminEntity> saveAllAdmins(List<AdminEntity> admins) {
//        return adminRepository.saveAll(admins);
//    }
//
//    public List<EmployeeEntity> saveAllEmployees(List<EmployeeEntity> employees) {
//        return employeeRepository.saveAll(employees);
//    }
//
//    public List<MedicineEntity> saveAllMedicinesAsList(List<MedicineEntity> medicines) {
//        return medicineRepository.saveAll(medicines);
//    }
//
//    public List<RestockEntity> saveAllRestocDetails(List<RestockEntity> restock) {
//        for (RestockEntity r : restock) {
//            validateMedicineExists(r.getMedicineId());
//        }
//        return restockRepository.saveAll(restock);
//    }
//
//    public List<SalesEntity> saveAllDetailsOfSales(List<SalesEntity> salesEntityList) {
//        for (SalesEntity s : salesEntityList) {
//            validateMedicineExists(s.getMedicineId());
//        }
//        return salesRepository.saveAll(salesEntityList);
//    }
//
//
//    public AdminEntity saveAdminDetail(AdminEntity admin) {
//        return adminRepository.save(admin);
//    }
//
//    public EmployeeEntity saveEmployeeDetail(EmployeeEntity employee) {
//        return employeeRepository.save(employee);
//    }
//
//    public MedicineEntity saveMedicineDetail(MedicineEntity medicine) {
//        return medicineRepository.save(medicine);
//    }
//
//    public RestockEntity saveRestockDetail(RestockEntity restockEntity) {
//        validateMedicineExists(restockEntity.getMedicineId());
//        return restockRepository.save(restockEntity);
//    }
//
//    public SalesEntity saveSalesDetail(SalesEntity salesEntity) {
//        validateMedicineExists(salesEntity.getMedicineId());
//        return salesRepository.save(salesEntity);
//    }
//
//    // Update
////    public UserDetailsEntity updateUserDetail(UserEntity user) {
////        UserEntity u = userEntityRepository.findById(user.getId()).orElse(null);
////        u.setName(user.getName());
////        u.setPassword(user.getPassword());
////        u.setRoles(user.getRoles());
////        return userEntityRepository.save(u);
////    }
//    public AdminEntity updateAdminDetail(AdminEntity admin) {
//        AdminEntity a = adminRepository.findById(admin.getId()).orElse(null);
//        a.setName(admin.getName());
//        a.setPassword(admin.getPassword());
//        a.setRoles(admin.getRoles());
//        return adminRepository.save(a);
//    }
//
//    public EmployeeEntity updateEmployeeDetail(EmployeeEntity employee) {
//        EmployeeEntity e = employeeRepository.findById(employee.getId()).orElse(null);
//        e.setName(employee.getName());
//        e.setPassword(employee.getPassword());
//        e.setRoles(employee.getRoles());
//        return employeeRepository.save(e);
//    }
//
//    public MedicineEntity updateMedicineDetail(MedicineEntity medicine) {
//        MedicineEntity m = medicineRepository.findById(medicine.getId()).orElse(null);
//        m.setName(medicine.getName());
//        m.setCategory(medicine.getCategory());
//        m.setType(medicine.getType());
//        m.setQuantity(medicine.getQuantity());
//        m.setPrice(medicine.getPrice());
//        return medicineRepository.save(m);
//    }
//
//    public RestockEntity updateRestockDetail(RestockEntity restock) {
//        RestockEntity r = restockRepository.findById(restock.getId()).orElse(null);
//        validateMedicineExists(restock.getMedicineId());
//        r.setMedicineId(restock.getMedicineId());
//        r.setQuantityRequest(restock.getQuantityRequest());
//        r.setStatus(restock.getStatus());
//        r.setRequestedDate(restock.getRequestedDate());
//        r.setBuyingPrice(restock.getBuyingPrice());
//        return restockRepository.save(r);
//    }
//
//    public SalesEntity updateSalesDetail(SalesEntity sales) {
//        SalesEntity s = salesRepository.findById(sales.getId()).orElse(null);
//        validateMedicineExists(sales.getMedicineId());
//        s.setMedicineId(sales.getMedicineId());
//        s.setQuantitySold(sales.getQuantitySold());
//        s.setRemainingQuantity(sales.getRemainingQuantity());
//        s.setSoldDate(sales.getSoldDate());
//        s.setSellingPrice(sales.getSellingPrice());
//        return salesRepository.save(s);
//    }
//
//    // Delete
//    public String deleteAdminDetails(int id) {
//        adminRepository.deleteById(id);
//        return "Successfully deleted " + id;
//    }
//
//    public String deleteEmployeeDetails(int id) {
//        employeeRepository.deleteById(id);
//        return "Successfully deleted " + id;
//    }
//
//    public String deleteMedicineDetails(int id) {
//        medicineRepository.deleteById(id);
//        return "Successfully deleted " + id;
//    }
//        public String deleteRestockDetails ( int id){
//            restockRepository.deleteById(id);
//            return "Successfully deleted " + id;
//        }
//
//        public String deleteSalesDetails ( int id){
//            salesRepository.deleteById(id);
//            return "Successfully deleted " + id;
//        }
//
//
//
//        private void validateMedicineExists ( int medicineId){
//            if (!medicineRepository.existsById(medicineId)) {
//                throw new RuntimeException("Medicine with ID " + medicineId + " does not exist");
//            }
//        }
//
//}
package com.medical.management.system.medical.management.service;

import com.medical.management.system.medical.management.entity.*;
import com.medical.management.system.medical.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    public AdminEntity getAdminDetailsById(int id) {
        try {
            Optional<AdminEntity> adminOptional = adminRepository.findById(id);
            return adminOptional.orElseThrow(() -> new RuntimeException("Admin with ID " + id + " not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving admin details: " + e.getMessage());
        }
    }

    public EmployeeEntity getEmployeeDetailById(int id) {
        try {
            Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);
            return employeeOptional.orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving employee details: " + e.getMessage());
        }
    }

    public MedicineEntity getMedicineDetailsById(int id) {
        try {
            Optional<MedicineEntity> medicineOptional = medicineRepository.findById(id);
            return medicineOptional.orElseThrow(() -> new RuntimeException("Medicine with ID " + id + " not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving medicine details: " + e.getMessage());
        }
    }

    public RestockEntity getRestockDetailsById(int id) {
        try {
            Optional<RestockEntity> restockOptional = restockRepository.findById(id);
            return restockOptional.orElseThrow(() -> new RuntimeException("Restock with ID " + id + " not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving restock details: " + e.getMessage());
        }
    }

    public SalesEntity getSalesDetailById(int id) {
        try {
            Optional<SalesEntity> salesOptional = salesRepository.findById(id);
            return salesOptional.orElseThrow(() -> new RuntimeException("Sales with ID " + id + " not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving sales details: " + e.getMessage());
        }
    }

    public AdminEntity getAdminByName(String name) {
        try {
            AdminEntity admin = adminRepository.findByName(name);
            if (admin == null) {
                throw new RuntimeException("Admin with name " + name + " not found");
            }
            return admin;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving admin by name: " + e.getMessage());
        }
    }

    public EmployeeEntity getEmployeeByName(String name) {
        try {
            EmployeeEntity employee = employeeRepository.findByName(name);
            if (employee == null) {
                throw new RuntimeException("Employee with name " + name + " not found");
            }
            return employee;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving employee by name: " + e.getMessage());
        }
    }

    public MedicineEntity getMedicineByName(String name) {
        try {
            MedicineEntity medicine = medicineRepository.findByName(name);
            if (medicine == null) {
                throw new RuntimeException("Medicine with name " + name + " not found");
            }
            return medicine;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving medicine by name: " + e.getMessage());
        }
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
// Continued from the previous response...

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

    public String deleteAdminDetails(int id) {
        try {
            adminRepository.deleteById(id);
            return "Successfully deleted admin with ID " + id;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting admin: " + e.getMessage());
        }
    }

    public String deleteEmployeeDetails(int id) {
        try {
            employeeRepository.deleteById(id);
            return "Successfully deleted employee with ID " + id;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting employee: " + e.getMessage());
        }
    }

    public String deleteMedicineDetails(int id) {
        try {
            medicineRepository.deleteById(id);
            return "Successfully deleted medicine with ID " + id;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting medicine: " + e.getMessage());
        }
    }

    public String deleteRestockDetails(int id) {
        try {
            restockRepository.deleteById(id);
            return "Successfully deleted restock with ID " + id;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting restock: " + e.getMessage());
        }
    }

    public String deleteSalesDetails(int id) {
        try {
            salesRepository.deleteById(id);
            return "Successfully deleted sales with ID " + id;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting sales: " + e.getMessage());
        }
    }

    private void validateMedicineExists(int medicineId) {
        if (!medicineRepository.existsById(medicineId)) {
            throw new RuntimeException("Medicine with ID " + medicineId + " does not exist");
        }
    }
}
