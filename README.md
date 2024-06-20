Overview
The Medical Management System is a robust application designed to streamline operations within a medical store. It encompasses a range of functionalities including inventory management, sales reporting, user authentication, and access control. Developed using Spring Boot,the system ensures efficiency, security, and reliability.

Features:

->Inventory Management: Efficiently manage medicines and stock levels.
->Sales Reporting: Generate detailed sales reports.
->User Authentication: Secure user authentication with JWT.
->Employee Management: Manage employee records.
->Restock Management: Handle restocking of medicines.
->CSV Generation: Export data to CSV files.

Technologies Used:
->Java
->SpringBoot
->SpringDataJpa
->MySQl

Prerequisites:
Java 8 or higher
Maven 3.6.0 or higher
MySQL 

Usage: 

API Endpoints
Admin APIs

Add New User Details:
POST /pharmacy/add/detailsOfUser
Authorization: ROLE_ADMIN
Adds a new user detail.

Add Admin Information:
POST /pharmacy/add/adminInfo
Authorization: ROLE_ADMIN
Adds details of an admin.

Add Employee Information:
POST /pharmacy/add/employeeInfo
Authorization: ROLE_ADMIN
Adds details of an employee.

Add Medicine Information:
POST /pharmacy/add/medicineInfo
Authorization: ROLE_ADMIN
Adds details of a medicine.

Add Restock Information:
POST /pharmacy/add/restockInfo
Authorization: ROLE_ADMIN
Adds details of a restock.

Add Sales Information:
POST /pharmacy/add/salesInfo
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Adds details of a sale.

Add List of Admins:
POST /pharmacy/add/ListOfAdmins
Authorization: ROLE_ADMIN
Adds multiple admin details.

Add List of Employees:
POST /pharmacy/add/ListOfEmployees
Authorization: ROLE_ADMIN
Adds multiple employee details.

Add List of Medicines:
POST /pharmacy/add/ListOfMedicines
Authorization: ROLE_ADMIN
Adds multiple medicine details.

Add List of Restocks:
POST /pharmacy/add/ListOfRestocks
Authorization: ROLE_ADMIN
Adds multiple restock details.

Add List of Sales:
POST /pharmacy/add/ListOfSales
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Adds multiple sales details.

Get All Admins:
GET /pharmacy/display/AllAdmins
Authorization: ROLE_ADMIN
Retrieves all admin details.

Get Admin By ID:
GET /pharmacy/display/AdminById/{id}
Authorization: ROLE_ADMIN
Retrieves admin details by ID.

Get Admin By Name:
GET /pharmacy/display/AdminDetailsByName/{name}
Authorization: ROLE_ADMIN
Retrieves admin details by name.

Update Admin Details:
PUT /pharmacy/update/Admin
Authorization: ROLE_ADMIN
Updates admin details.

Delete Admin By ID:
DELETE /pharmacy/delete/Admins/{id}
Authorization: ROLE_ADMIN
Deletes admin details by ID.

Employee APIs

Get All Employees:
GET /pharmacy/display/AllEmployees
Authorization: ROLE_ADMIN
Retrieves all employee details.

Get Employee By ID:
GET /pharmacy/display/EmployeeById/{id}
Authorization: ROLE_ADMIN
Retrieves employee details by ID.

Get Employee By Name:
GET /pharmacy/display/EmployeeDetailsByName/{name}
Authorization: ROLE_ADMIN
Retrieves employee details by name.

Update Employee Details:
PUT /pharmacy/update/Employee
Authorization: ROLE_ADMIN
Updates employee details.

Delete Employee By ID:
DELETE /pharmacy/delete/Employee/{id}
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Deletes employee details by ID.

Medicine APIs
Get All Medicines:
GET /pharmacy/display/AllMedicines
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Retrieves all medicine details.

Get Medicine By Category:
GET /pharmacy/display/MedicineByCategory/{category}
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Retrieves medicine details by category.

Get Medicine By Type:
GET /pharmacy/display/MedicineByType/{type}
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Retrieves medicine details by type.

Get Medicine By ID:
GET /pharmacy/display/MedicineById/{id}
Authorization: ROLE_ADMIN
Retrieves medicine details by ID.

Get Medicine By Name:
GET /pharmacy/display/MedicineDetailsByName/{name}
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Retrieves medicine details by name.

Update Medicine Details
PUT /pharmacy/update/Medicine
Authorization: ROLE_ADMIN
Updates medicine details.

Delete Medicine By ID:
DELETE /pharmacy/delete/Medicine/{id}
Authorization: ROLE_ADMIN
Deletes medicine details by ID.

Restock APIs
Get All Restocks
GET /pharmacy/display/AllRestocks
Authorization: ROLE_ADMIN
Retrieves all restock details.

Get Restock By ID:
GET /pharmacy/display/RestockById/{id}
Authorization: ROLE_ADMIN
Retrieves restock details by ID.

Update Restock Details:
PUT /pharmacy/update/Restock
Authorization: ROLE_ADMIN
Updates restock details.

Delete Restock By ID:
DELETE /pharmacy/delete/Restock/{id}
Authorization: ROLE_ADMIN
Deletes restock details by ID.

Sales APIs
Get All Sales:
GET /pharmacy/display/AllSales
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Retrieves all sales details.

Get Sales By ID:
GET /pharmacy/display/SalesById/{id}
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Retrieves sales details by ID.

Update Sales Details:
PUT /pharmacy/update/Sales
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Updates sales details.

Delete Sales By ID:
DELETE /pharmacy/delete/Sales/{id}
Authorization: ROLE_ADMIN or ROLE_EMPLOYEE
Deletes sales details by ID.

Authentication APIs

Authenticate and Get Token:
POST /pharmacy/authenticate
Authenticates a user and generates a JWT token.

Invoice APIs

Generate Sales Invoice:
GET /pharmacy/invoice/sales/{salesId}
Generates an invoice for a specific sales ID.

Generate Restock Invoice:
GET /pharmacy/invoice/restock/{restockId}
Generates an invoice for a specific restock ID.

Security:
The application uses JWT for authentication and authorization. The SecurityConfig class configures the security settings, and the JwtAuthFilter class handles the JWT validation.

Key components include:
Authentication: Secure login endpoints.
Authorization: Role-based access control.
JWT Tokens: Issuance and validation of JWTs for secure communication.
