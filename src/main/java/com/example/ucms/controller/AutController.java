package com.example.ucms.controller;


import com.example.ucms.DTO.Auth.LoginRequest;
import com.example.ucms.entity.Users;
import com.example.ucms.exception.ApiSuccessResponse;
import com.example.ucms.repository.UserRepository;
import com.example.ucms.services.AutServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AutController {
        private final AutServices autServices;


    @PostMapping("/api/auth/login")
    public ResponseEntity<ApiSuccessResponse> login(@Valid @RequestBody LoginRequest loginRequest , HttpServletRequest request){
        autServices.Login(loginRequest);
        ApiSuccessResponse response = ApiSuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .path(request.getRequestURI())
                .message("Login Successfully")
                .build();
        return  new ResponseEntity<>(response , HttpStatus.CREATED);
    }

}
