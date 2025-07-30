package com.example.ucms.DTO.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank String full_name,
        @Email String email,
        @NotBlank String password_hash,
        @Min(0) int role_id
){}
