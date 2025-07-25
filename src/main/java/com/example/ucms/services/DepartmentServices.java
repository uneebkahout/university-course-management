package com.example.ucms.services;

import com.example.ucms.DTO.Departments.DepartmentRequest;
import com.example.ucms.DTO.Departments.DepartmentResponse;

import java.util.List;

public interface DepartmentServices {
    void createDepartment(DepartmentRequest request);
    List<DepartmentResponse> getDepartments();
    void updateDepartment(int department_id ,DepartmentRequest request);
    void deleteDepartment(int department_id);


};
