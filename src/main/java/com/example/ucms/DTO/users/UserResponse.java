package com.example.ucms.DTO.users;

public record UserResponse (
   int user_id,
    String full_name,
    String email,
    String password_hash,
    int role_id
    ){}
