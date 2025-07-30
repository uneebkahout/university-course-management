package com.example.ucms.DTO.Departments;

import jakarta.validation.constraints.NotBlank;

public record DepartmentRequest(
        @NotBlank String department_name,
        @NotBlank String head_of_department,
        @NotBlank String office_location
){}
