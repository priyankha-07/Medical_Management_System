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
MedicineController: Handles CRUD operations for medicines.

POST /pharmacy/add/detailsOfUser-->Adds details of a new user.
POST /pharmacy/add/adminInfoAdds--> details of a new admin.
POST /pharmacy/add/employeeInfo-->Adds details of a new employee.
POST /pharmacy/add/medicineInfo-->Adds details of a new medicine.
POST /pharmacy/add/restockInfo-->Adds details of a new restock.
POST /pharmacy/add/salesInfo-->Adds details of a new sales entry.
POST /pharmacy/add/ListOfAdmins-->Adds details of multiple admins.
POST /pharmacy/add/ListOfEmployees-->Adds details of multiple employees.
POST /pharmacy/add/ListOfMedicines-->Adds details of multiple medicines.
POST /pharmacy/add/ListOfRestocks-->Adds details of multiple restocks.
POST /pharmacy/add/ListOfSales-->Adds details of multiple sales entries.

GET Requests:

GET /pharmacy/display/AllAdmins-->Retrieves details of all admins.
GET /pharmacy/display/AllEmployees-->Retrieves details of all employees.
GET /pharmacy/display/AllMedicines-->Retrieves details of all medicines.
GET /pharmacy/display/MedicineByCategory/{category}-->Retrieves medicines by category.
GET /pharmacy/display/MedicineByType/{type}-->Retrieves medicines by type.
GET /pharmacy/display/AllRestocks-->Retrieves details of all restocks.
GET /pharmacy/display/AllSales-->Retrieves details of all sales entries.
GET /pharmacy/display/AdminById/{id}-->Retrieves admin details by ID.
GET /pharmacy/display/EmployeeById/{id}-->Retrieves employee details by ID.
GET /pharmacy/display/MedicineById/{id}-->Retrieves medicine details by ID.
GET /pharmacy/display/RestockById/{id}-->Retrieves restock details by ID.
GET /pharmacy/display/SalesById/{id}-->Retrieves sales details by ID.
GET /pharmacy/display/AdminDetailsByName/{name}-->Retrieves admin details by name.
GET /pharmacy/display/EmployeeDetailsByName/{name}-->Retrieves employee details by name.
GET /pharmacy/display/MedicineDetailsByName/{name}-->Retrieves medicine details by name.
GET /pharmacy/invoice/sales/{salesId}-->Generates sales invoice by sales ID.
GET /pharmacy/invoice/restock/{restockId}-->Generates restock invoice by restock ID.

PUT Requests:
PUT /pharmacy/update/Admin-->Updates details of an admin.
PUT /pharmacy/update/Employee-->Updates details of an employee.
PUT /pharmacy/update/Medicine-->Updates details of a medicine.
PUT /pharmacy/update/Restock-->Updates details of a restock.
PUT /pharmacy/update/Sales-->Updates details of a sales entry.

DELETE Requests:
DELETE /pharmacy/delete/Admins/{id}-->Deletes an admin by ID.
DELETE /pharmacy/delete/Employee/{id}-->Deletes an employee by ID.
DELETE /pharmacy/delete/Medicine/{id}-->Deletes a medicine by ID.
DELETE /pharmacy/delete/Restock/{id}-->Deletes a restock by ID.
DELETE /pharmacy/delete/Sales/{id}-->Deletes a sales entry by ID.

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
