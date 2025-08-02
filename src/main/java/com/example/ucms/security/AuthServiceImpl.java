package com.example.ucms.security;

import com.example.ucms.DTO.Auth.LoginRequest;
import com.example.ucms.DTO.Auth.LoginResponse;
import com.example.ucms.entity.Users;
import com.example.ucms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AutServices {
private  final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
private final AuthUtil authUtil;
    @Override
    public LoginResponse Login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email() , loginRequest.password())
        );
            Users user = (Users) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);

//        Users user = userRepository.findByEmail(loginRequest.email())
//                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword_hash())) {
//            throw new IllegalArgumentException("Invalid credentials");
//        }


        return new LoginResponse(token);
    }

}
