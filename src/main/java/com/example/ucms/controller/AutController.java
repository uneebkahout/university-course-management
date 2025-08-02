package com.example.ucms.controller;


import com.example.ucms.DTO.Auth.LoginRequest;
import com.example.ucms.DTO.Auth.LoginResponse;
import com.example.ucms.exception.ApiSuccessResponse;
import com.example.ucms.security.AutServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AutController {
        private final AutServices autServices;
    @PostMapping("/api/auth/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest , HttpServletRequest request){
      LoginResponse response =  autServices.Login(loginRequest);
//        ApiSuccessResponse response = ApiSuccessResponse.builder()
//                .status(HttpStatus.OK.value())
//                .path(request.getRequestURI())
//                .message("Login Successfully")
//                .build();
        return  new ResponseEntity<>(response , HttpStatus.CREATED);
    }

}
