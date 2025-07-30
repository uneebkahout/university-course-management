📡 API Overview
This project includes a set of RESTful APIs developed using Spring Boot to manage core modules of a university course management system.

✅ Built Modules
Role API – Manage user roles (Admin, Faculty, Student)

User API – Create and manage system users

Student API – Manage student profiles

Faculty API – Manage faculty profiles

Department API – Manage academic departments

🚀 Base URL
bash
Copy
Edit
http://localhost:8080/api
Adjust if deploying to a different host or port.

📚 API Endpoints
🔐 Roles
Method	Endpoint	Description
GET	/getroles	Get all roles
POST	/addroles	Create a new role
PUT	/updateroles/{id}	Update an existing role
DELETE	/deleteroles/{id}	Delete a role by ID

👥 Users
Method	Endpoint	Description
GET	/getusers	Get all users
POST	/addusers	Create a new user
PUT	/updageusers/{id}	Update user info
DELETE	/deleteusers/{id}	Delete a user

🎓 Students
Method	Endpoint	Description
GET	/getstudents	Get all student records
POST	/addstudents	Add a new student
PUT	/updatestudents/{id}	Update student profile
DELETE	/deletedstudents/{id}	Remove a student record

👨‍🏫 Faculty
Method	Endpoint	Description
GET	/getfaculty	Get all faculty members
POST	/addfaculty	Add a new faculty
PUT	/updatefaculty/{id}	Update faculty info
DELETE	/deletefaculty/{id}	Delete a faculty record

🏢 Departments
Method	Endpoint	Description
GET	/getdepartments	Get all departments
POST	/adddepartments	Add a new department
PUT	/updatedepartments/{id}	Update department info
DELETE	/deletedepartments/{id}	Delete a department

🔐 Authentication (Coming Soon)
JWT-based authentication and role-based access control will be added in future updates.

🧪 Testing
Use tools like Postman or Insomnia to test API endpoints.

📦 Technologies Used
Spring Boot

Spring Data JPA

SQL Server

Maven

Validation

Lombok

🛠️ Setup Instructions
Clone the repository.

Configure application.properties to connect to SQL Server.

Run the Spring Boot application.

Use /api endpoints to interact with the system.
