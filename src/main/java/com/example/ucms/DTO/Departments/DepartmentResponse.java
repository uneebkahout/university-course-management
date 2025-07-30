package com.example.ucms.DTO.Departments;

import jakarta.validation.constraints.NotBlank;

public record DepartmentResponse (
        int department_id,
         String department_name,
         String head_of_department,
         String office_location
){}
