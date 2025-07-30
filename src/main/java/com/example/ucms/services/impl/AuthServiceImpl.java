package com.example.ucms.services.impl;

import com.example.ucms.DTO.Auth.LoginRequest;
import com.example.ucms.DTO.users.UserResponse;
import com.example.ucms.entity.Users;
import com.example.ucms.exception.ResourceNotFoundException;
import com.example.ucms.repository.UserRepository;
import com.example.ucms.services.AutServices;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AutServices {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void Login(LoginRequest loginRequest) {
        Users user = userRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword_hash())) {
            throw new IllegalArgumentException("Invalid credentials");
        }


    }

}
