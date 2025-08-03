package com.example.ucms.DTO.Auth;

public record LoginResponse (

       int Status,
        String message,
        String role,
        Boolean Valid,
        String token
){}
