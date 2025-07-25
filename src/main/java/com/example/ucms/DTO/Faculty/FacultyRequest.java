package com.example.ucms.DTO.Faculty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record FacultyRequest (
         @Min(0) int user_id,
       @NotBlank String employee_number,
        @NotBlank String department,
        @NotBlank  String designation,
        @NotBlank String qualification,
        @NotBlank  String contact_number,
        @NotBlank  String office_location,
        @NotNull Date hire_date
){}
