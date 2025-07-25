package com.example.ucms.DTO.Faculty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record FacultyResponse(
        int faculty_id,
        int user_id,
        String employee_number,
        String department,
        String designation,
        String qualification,
        String contact_number,
        String office_location,
        Date hire_date
) {
}
