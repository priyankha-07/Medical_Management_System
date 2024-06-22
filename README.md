<!DOCTYPE html>
<html lang="en">
<body>
<h1>Medical Management System</h1>

<h2>Overview</h2>
<p>The Medical Management System is a robust application designed to streamline operations within a medical store. It encompasses a range of functionalities including inventory management, sales reporting, user authentication, and access control. Developed using Spring Boot, the system ensures efficiency, security, and reliability.</p>

<h2>Features</h2>
<ul>
    <li><strong>Inventory Management</strong>: Efficiently manage medicines and stock levels.</li>
    <li><strong>Sales Reporting</strong>: Generate detailed sales reports.</li>
    <li><strong>User Authentication</strong>: Secure user authentication with JWT.</li>
    <li><strong>Employee Management</strong>: Manage employee records.</li>
    <li><strong>Restock Management</strong>: Handle restocking of medicines.</li>
    <li><strong>CSV Generation</strong>: Export data to CSV files.</li>
</ul>

<h2>Technologies Used</h2>
<ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>MySQL</li>
</ul>

<h2>Prerequisites</h2>
<ul>
    <li>Java 8 or higher</li>
    <li>Maven 3.6.0 or higher</li>
    <li>MySQL</li>
</ul>

<h2>Usage</h2>

<h3>API Endpoints</h3>

<h4>MedicineController: Handles CRUD operations for medicines.</h4>

<h5>POST Requests:</h5>
<pre><code>POST /pharmacy/add/detailsOfUser        -> Adds details of a new user.
POST /pharmacy/add/adminInfo            -> Adds details of a new admin.
POST /pharmacy/add/employeeInfo         -> Adds details of a new employee.
POST /pharmacy/add/medicineInfo         -> Adds details of a new medicine.
POST /pharmacy/add/restockInfo          -> Adds details of a new restock.
POST /pharmacy/add/salesInfo            -> Adds details of a new sales entry.
POST /pharmacy/add/ListOfAdmins         -> Adds details of multiple admins.
POST /pharmacy/add/ListOfEmployees      -> Adds details of multiple employees.
POST /pharmacy/add/ListOfMedicines      -> Adds details of multiple medicines.
POST /pharmacy/add/ListOfRestocks       -> Adds details of multiple restocks.
POST /pharmacy/add/ListOfSales          -> Adds details of multiple sales entries.
</code></pre>

<h5>GET Requests:</h5>
<pre><code>GET /pharmacy/display/AllAdmins                      -> Retrieves details of all admins.
GET /pharmacy/display/AllEmployees                   -> Retrieves details of all employees.
GET /pharmacy/display/AllMedicines                   -> Retrieves details of all medicines.
GET /pharmacy/display/MedicineByCategory/{category}  -> Retrieves medicines by category.
GET /pharmacy/display/MedicineByType/{type}          -> Retrieves medicines by type.
GET /pharmacy/display/AllRestocks                    -> Retrieves details of all restocks.
GET /pharmacy/display/AllSales                       -> Retrieves details of all sales entries.
GET /pharmacy/display/AdminById/{id}                 -> Retrieves admin details by ID.
GET /pharmacy/display/EmployeeById/{id}              -> Retrieves employee details by ID.
GET /pharmacy/display/MedicineById/{id}              -> Retrieves medicine details by ID.
GET /pharmacy/display/RestockById/{id}               -> Retrieves restock details by ID.
GET /pharmacy/display/SalesById/{id}                 -> Retrieves sales details by ID.
GET /pharmacy/display/AdminDetailsByName/{name}      -> Retrieves admin details by name.
GET /pharmacy/display/EmployeeDetailsByName/{name}   -> Retrieves employee details by name.
GET /pharmacy/display/MedicineDetailsByName/{name}   -> Retrieves medicine details by name.
GET /pharmacy/invoice/sales/{salesId}                -> Generates sales invoice by sales ID.
GET /pharmacy/invoice/restock/{restockId}            -> Generates restock invoice by restock ID.
</code></pre>

<h5>PUT Requests:</h5>
<pre><code>PUT /pharmacy/update/Admin    -> Updates details of an admin.
PUT /pharmacy/update/Employee -> Updates details of an employee.
PUT /pharmacy/update/Medicine -> Updates details of a medicine.
PUT /pharmacy/update/Restock  -> Updates details of a restock.
PUT /pharmacy/update/Sales    -> Updates details of a sales entry.
</code></pre>

<h5>DELETE Requests:</h5>
<pre><code>DELETE /pharmacy/delete/Admins/{id}    -> Deletes an admin by ID.
DELETE /pharmacy/delete/Employee/{id}  -> Deletes an employee by ID.
DELETE /pharmacy/delete/Medicine/{id}  -> Deletes a medicine by ID.
DELETE /pharmacy/delete/Restock/{id}   -> Deletes a restock by ID.
DELETE /pharmacy/delete/Sales/{id}     -> Deletes a sales entry by ID.
</code></pre>

<h3>Authentication APIs</h3>

<h5>Authenticate and Get Token:</h5>
<pre><code>POST /pharmacy/authenticate  -> Authenticates a user and generates a JWT token.
</code></pre>

<h3>Invoice APIs</h3>

<h5>Generate Sales Invoice:</h5>
<pre><code>GET /pharmacy/invoice/sales/{salesId}  -> Generates an invoice for a specific sales ID.
</code></pre>

<h5>Generate Restock Invoice:</h5>
<pre><code>GET /pharmacy/invoice/restock/{restockId}  -> Generates an invoice for a specific restock ID.
</code></pre>

<h2>Security</h2>
<p>The application uses JWT for authentication and authorization. The <code>SecurityConfig</code> class configures the security settings, and the <code>JwtAuthFilter</code> class handles the JWT validation.</p>

<p>Key components include:</p>
<ul>
    <li><strong>Authentication</strong>: Secure login endpoints.</li>
    <li><strong>Authorization</strong>: Role-based access control.</li>
    <li><strong>JWT Tokens</strong>: Issuance and validation of JWTs for secure communication.</li>
</ul>

</body>
</html>
