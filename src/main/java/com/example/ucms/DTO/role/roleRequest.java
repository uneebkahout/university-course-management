package com.example.ucms.DTO.role;

import jakarta.validation.constraints.NotBlank;

public record roleRequest (
    @NotBlank String role_name
){}
