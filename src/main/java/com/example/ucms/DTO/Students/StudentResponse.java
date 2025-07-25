package com.example.ucms.DTO.Students;

import java.util.Date;

public record StudentResponse(
        int student_id,
        int user_id,
        String student_number,
        Date date_of_birth,
        String gender,
        String department,
        String contact_number,
        String address,
        Date admission_date

        ){}
