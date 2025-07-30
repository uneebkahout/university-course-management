package com.example.ucms.DTO.Students;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record StudentRequest (
          @Min(0) int user_id,
          @NotBlank String student_number,
         @NotNull  Date date_of_birth,
         @NotBlank  String gender,
         @NotBlank String department,
         @NotBlank String contact_number,
         @NotBlank   String address,
         @NotNull Date admission_date
){}
