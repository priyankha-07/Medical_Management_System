package com.medical.management.system.medical.management.controller;

import com.medical.management.system.medical.management.entity.*;
import com.medical.management.system.medical.management.service.InvoiceRestockService;
import com.medical.management.system.medical.management.service.InvoiceSalesService;
import com.medical.management.system.medical.management.service.JwtService;
import com.medical.management.system.medical.management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pharmacy")
public class MedicineController
{
    @Autowired
    private MedicineService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private InvoiceSalesService invoiceService;
    @Autowired
    private InvoiceRestockService invoiceRestockService;

@PostMapping("/add/detailsOfUser")
@PreAuthorize("has Authority('ROLE_ADMIN')")
 public  String addNewUserDetails(@RequestBody UserDetailsEntity userDetailsEntity){
    return service.addUserInfo(userDetailsEntity);
}
    @PostMapping("/add/adminInfo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public AdminEntity addDetailsOfAdmin(@RequestBody AdminEntity adminEntity){
        return service.saveAdminDetail(adminEntity);
    }

    @PostMapping("/add/employeeInfo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public EmployeeEntity addDetailsOfEmployee(@RequestBody EmployeeEntity employeeEntity){
        return service.saveEmployeeDetail(employeeEntity);
    }

    @PostMapping("/add/medicineInfo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public MedicineEntity addDetailsOfMedicine(@RequestBody MedicineEntity medicineEntity){
        return service.saveMedicineDetail(medicineEntity);
    }

    @PostMapping("/add/restockInfo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public RestockEntity addDetailsOfRestock(@RequestBody RestockEntity restockEntity){
        return service.saveRestockDetail(restockEntity);
    }

    @PostMapping("/add/salesInfo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")

    public SalesEntity addDetailsOfSales(@RequestBody SalesEntity salesEntity){
        return service.saveSalesDetail(salesEntity);
    }

    @PostMapping("/add/ListOfAdmins")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<AdminEntity> addAdminDetails(@RequestBody List<AdminEntity> admins) {
        return service.saveAllAdmins(admins);
    }
    @PostMapping("/add/ListOfEmployees")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<EmployeeEntity> addEmployeeDetails(@RequestBody List<EmployeeEntity> employees) {
        return service.saveAllEmployees(employees);
    }
    @PostMapping("/add/ListOfMedicines")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<MedicineEntity> addMedicineDetails(@RequestBody List<MedicineEntity> medicines) {
        return service.saveAllMedicinesAsList(medicines);
    }
    @PostMapping("/add/ListOfRestocks")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<RestockEntity> addRestockDetails(@RequestBody List<RestockEntity> restockEntities) {
        return service.saveAllRestocDetails(restockEntities);
    }
    @PostMapping("/add/ListOfSales")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")
    public List<SalesEntity> addSalesDetails(@RequestBody List<SalesEntity> salesEntities) {
        return service.saveAllDetailsOfSales(salesEntities);
    }


    @GetMapping("/display/AllAdmins")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<AdminEntity> findAllAdminDetails() {
        try {
            return service.getAllAdminsInfo();
        } catch (RuntimeException ex) {
            throw new RuntimeException("Failed to fetch admin details");
        }
    }


    @GetMapping("/display/AllEmployees")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public List<EmployeeEntity> findAllEmployeeDetails() {
        return service.getAllEmployeesInfo();
    }

    @GetMapping("/display/AllMedicines")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")

    public List<MedicineEntity> findAllMedicineDetails() {
        return service.getAllMedicinesInfo();
    }
    @GetMapping("/display/MedicineByCategory/{category}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")

    public ResponseEntity<?> findMedicineByCategory(@PathVariable String category) {
        try {
            List<MedicineEntity> medicines = service.getMedicineByCategory(category);
            return new ResponseEntity<>(medicines, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/display/MedicineByType/{type}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")


    public ResponseEntity<?> findMedicineByType(@PathVariable String type) {
        try {
            List<MedicineEntity> medicines = service.getMedicineByType(type);
            return new ResponseEntity<>(medicines, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/display/AllRestocks")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') ")

    public List<RestockEntity> findAllRestockDetails() {
        return service.getAllDetailsOfRestock();
    }
    @GetMapping("/display/AllSales")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")

    public List<SalesEntity> findAllSalesDetails() {
        return service.getAllDetailsOfSales();
    }

    @GetMapping("/display/AdminById/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> findAdminById(@PathVariable int id) {
        try {
            AdminEntity admin = service.getAdminDetailsById(id);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Admin with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/display/EmployeeById/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> findEmployeeById(@PathVariable int id) {
        try {
            EmployeeEntity employee = service.getEmployeeDetailById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Employee with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/display/MedicineById/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> findMedicineById(@PathVariable int id) {
        try {
            MedicineEntity medicine = service.getMedicineDetailsById(id);
            return new ResponseEntity<>(medicine, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Medicine with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/display/RestockById/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public ResponseEntity<?> findRestockById(@PathVariable int id) {
        try {
            RestockEntity restock = service.getRestockDetailsById(id);
            return new ResponseEntity<>(restock, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Restock with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/display/SalesById/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")

    public ResponseEntity<?> findSalesById(@PathVariable int id) {
        try {
            SalesEntity sales = service.getSalesDetailById(id);
            return new ResponseEntity<>(sales, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Sales with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

//Get Details By Name

    @GetMapping("/display/AdminDetailsByName/{name}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> findAdminByName(@PathVariable String name) {
        try {
            AdminEntity admin = service.getAdminDetailByName(name);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Admin with Name " + name + " not found", HttpStatus.NOT_FOUND);
        }
    }

        @GetMapping("/display/EmployeeDetailsByName/{name}")
        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        public ResponseEntity<?> findEmployeeByName(@PathVariable String name) {
            try {
                EmployeeEntity employee = service.getEmployeeByName(name);
                return new ResponseEntity<>(employee, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>("Employee with Name " + name + " not found", HttpStatus.NOT_FOUND);
            }
        }
    @GetMapping("/display/MedicineDetailsByName/{name}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")
    public ResponseEntity<?> findMedicineByName(@PathVariable String name) {
        try {
            MedicineEntity medicine = service.getMedicineByName(name);
            return new ResponseEntity<>(medicine, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Medicine with Name " + name + " not found", HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping("/update/Admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public AdminEntity updateAdminDetails(@RequestBody AdminEntity admin) {
        return service. updateAdminDetail(admin);
    }
    @PutMapping("/update/Employee")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public EmployeeEntity updateEmployeeDetails(@RequestBody EmployeeEntity employee) {
        return service. updateEmployeeDetail(employee);
    }
    @PutMapping("/update/Medicine")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public MedicineEntity updateMedicineDetails(@RequestBody MedicineEntity medicine) {
        return service. updateMedicineDetail(medicine);
    }
    @PutMapping("/update/Restock")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public RestockEntity updateRestockDetails(@RequestBody RestockEntity restock) {
        return service. updateRestockDetail(restock);
    }
    @PutMapping("/update/Sales")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")

    public SalesEntity updateSalesDetails(@RequestBody SalesEntity sales) {
        return service. updateSalesDetail(sales);
    }

   //delete
    @DeleteMapping("/delete/Admins/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public ResponseEntity<?> deleteAdminDetailById(@PathVariable int id) {
        try {
            AdminEntity admin = service.deleteAdminDetails(id);
            return new ResponseEntity<>("Admin with ID " + id + " successfully deleted", HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>("Admin with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/Employee/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")

    public ResponseEntity<?> deleteEmployeeDetailById(@PathVariable int id){
        try {
            EmployeeEntity employee = service.deleteEmployeeDetails(id);
            return new ResponseEntity<>("Employee with ID " + id + " successfully deleted", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("employee with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/Medicine/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public ResponseEntity<?> deleteMedicineDetailById(@PathVariable int id){
        try {
            MedicineEntity medicine = service.deleteMedicineDetails(id);
            return new ResponseEntity<>("Medicine with ID " + id + " successfully deleted", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Medicine with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/Restock/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public ResponseEntity<?> deleteRestockDetailById(@PathVariable int id){
        try {
            RestockEntity restock = service.deleteRestockDetails(id);
            return new ResponseEntity<>("Restock with ID " + id + " successfully deleted", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Restock with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/Sales/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_EMPLOYEE')")
    public ResponseEntity<?> deleteSalesDetailById(@PathVariable int id){
        try {
            SalesEntity sales = service.deleteSalesDetails(id);
            return new ResponseEntity<>("Sales with ID " + id + " successfully deleted", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Sales with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/authenticate")
    public JwtResponseDto authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return JwtResponseDto.builder()
                    .accessToken(jwtService.generateToken(authRequest.getUsername()))
                    .build();
        } else {
            throw new UsernameNotFoundException("Invalid user request..!!");
        }
    }

@GetMapping("/invoice/sales/{salesId}")
public ResponseEntity<String> generateSalesInvoice(@PathVariable int salesId) {
    String invoice;
    try {
        invoice = invoiceService.generateSalesInvoice(salesId);
    } catch (RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sales request not found for salesId: " + salesId);
    }
    return ResponseEntity.ok(invoice);
}

    @GetMapping("/invoice/restock/{restockId}")
    public ResponseEntity<String> generateRestockInvoice(@PathVariable int restockId) {
        String invoice;
        try {
            invoice = invoiceRestockService.generateRestockInvoice(restockId);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock request not found for restockId: " + restockId);
        }
        return ResponseEntity.ok(invoice);
    }

}
