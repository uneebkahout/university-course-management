CREATE DATABASE universityCourseManagement;
USE universityCourseManagement;

CREATE TABLE Roles (
    role_id INT PRIMARY KEY IDENTITY(1,1),
    role_name NVARCHAR(50) NOT NULL UNIQUE
);

-- USERS table 
CREATE TABLE Users (
    user_id INT PRIMARY KEY IDENTITY(1,1),
    full_name NVARCHAR(100),
    email NVARCHAR(100) UNIQUE,
    password_hash NVARCHAR(255),
    role_id INT FOREIGN KEY REFERENCES Roles(role_id)
);


	CREATE TABLE Students (
    student_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT FOREIGN KEY REFERENCES Users(user_id),
    student_number NVARCHAR(20) UNIQUE,
    date_of_birth DATE,
    gender NVARCHAR(10),
    department NVARCHAR(100),
    contact_number NVARCHAR(15),
    address NVARCHAR(255),
    admission_date DATE
);



-- FACULTY TABLE

CREATE TABLE Faculty (
    faculty_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT UNIQUE FOREIGN KEY REFERENCES Users(user_id),
    employee_number NVARCHAR(20) UNIQUE,
    department NVARCHAR(100),
    designation NVARCHAR(100),
    qualification NVARCHAR(100),
    contact_number NVARCHAR(15),
    office_location NVARCHAR(100),
    hire_date DATE
);




-- DEPARTMENT TABLE

CREATE TABLE Departments (
    department_id INT PRIMARY KEY IDENTITY(1,1),
    department_name NVARCHAR(100) UNIQUE NOT NULL,
    head_of_department NVARCHAR(100), -- optional
    office_location NVARCHAR(100)
);
-- COURSES TABLE 
CREATE TABLE Courses (
    course_id INT PRIMARY KEY IDENTITY(1,1),
    course_code NVARCHAR(20) UNIQUE,
    course_name NVARCHAR(100),
    credits INT,
    department_id INT FOREIGN KEY REFERENCES Departments(department_id)
);

CREATE TABLE FacultyAssignments (
    assignment_id INT PRIMARY KEY IDENTITY(1,1),
    faculty_id INT FOREIGN KEY REFERENCES Faculty(faculty_id),
    course_id INT FOREIGN KEY REFERENCES Courses(course_id),
    assigned_date DATE DEFAULT GETDATE()
);

CREATE TABLE Enrollments (
    enrollment_id INT PRIMARY KEY IDENTITY(1,1),
    student_id INT FOREIGN KEY REFERENCES Students(student_id),
    course_id INT FOREIGN KEY REFERENCES Courses(course_id),
    enrollment_date DATE DEFAULT GETDATE(),
    status NVARCHAR(50) DEFAULT 'Enrolled' -- e.g., Enrolled, Dropped, Completed
);


CREATE TABLE Grades (
    grade_id INT PRIMARY KEY IDENTITY(1,1),
    enrollment_id INT FOREIGN KEY REFERENCES Enrollments(enrollment_id),
    grade NVARCHAR(5), -- e.g., A, B+, C, F, etc.
    graded_on DATE DEFAULT GETDATE()
);
CREATE TABLE Attendance (
    attendance_id INT PRIMARY KEY IDENTITY(1,1),
    enrollment_id INT FOREIGN KEY REFERENCES Enrollments(enrollment_id),
    attendance_date DATE,
    status NVARCHAR(10) -- e.g., Present, Absent, Late
);


