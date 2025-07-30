package com.example.ucms.services;

import com.example.ucms.DTO.Students.StudentRequest;
import com.example.ucms.DTO.Students.StudentResponse;

import java.util.List;

public interface StudentServices {

    void createStudent(StudentRequest request);
    List<StudentResponse> getStudent();
    void updateStudent(int student_id , StudentRequest request);
    void deleteStudent(int student_id);
}
