# University Course Management Database

This project contains a comprehensive SQL database schema for managing university courses, students, faculty, and other academic operations.

## 📘 Overview

The **University Course Management** system is designed to handle the following core functionalities:

- User and role management (Admins, Faculty, Students)
- Student and faculty profiles
- Department and course management
- Course enrollment and grading
-  attendance tracking
- Assignments and submissions
- Announcements and events
- Feedback and course evaluations

## 🗂️ Database Structure

### Core Tables

- `Roles` – Defines user roles (e.g., Admin, Faculty, Student)
- `Users` – Stores basic user information and links to roles
- `Students` – Student-specific information
- `Faculty` – Faculty-specific information
- `Departments` – Academic departments
- `Courses` – Course catalog

### Functional Tables

- `FacultyAssignments` – Tracks which faculty are assigned to which courses
- `Enrollments` – Manages course enrollment for students
- `Grades` – Stores grades awarded to students
- `ClassSchedule` – Defines class times and locations
- `Attendance` – Tracks student attendance
- `Announcements` – System-wide or course-specific messages
- `Assignments` – Coursework details
- `Submissions` – Tracks student submissions
- `Events` – Campus or academic events
- `CourseFeedback` – Feedback and evaluations from students

## 📄 How to Use

1. Clone or download this repository.
2. Open the `university_course_management.sql` file in your SQL Server environment (e.g., SSMS).
3. Execute the script to create the database and all related tables.
4. Start inserting test data or integrating with a backend system.

## ✅ Requirements

- SQL Server (2022 or later recommended)
- Basic knowledge of SQL and database design

## 🚀 Future Enhancements

- Add stored procedures and views
- Create ER diagrams
- Implement triggers for audit logging
- Support for semesters and academic years
- Optional integration with frontend/backend apps



---

### 📧 Contact

For questions or collaboration requests, feel free to open an issue or contact the repository maintainer.

