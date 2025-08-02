package com.example.ucms.security;

import com.example.ucms.DTO.Auth.LoginRequest;
import com.example.ucms.DTO.Auth.LoginResponse;

public interface AutServices {
    LoginResponse Login(LoginRequest loginRequest);

}
