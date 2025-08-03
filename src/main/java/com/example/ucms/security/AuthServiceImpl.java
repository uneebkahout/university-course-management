package com.example.ucms.security;

import com.example.ucms.DTO.Auth.LoginRequest;
import com.example.ucms.DTO.Auth.LoginResponse;
import com.example.ucms.entity.Roles;
import com.example.ucms.entity.Session;
import com.example.ucms.entity.Users;
import com.example.ucms.repository.RoleRepository;
import com.example.ucms.repository.SessionRepository;
import com.example.ucms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AutServices {
private  final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthUtil authUtil;
    private  final SessionRepository sessionRepository;
    private  final RoleRepository roleRepository;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(AuthServiceImpl.class);

    @Override
    public LoginResponse Login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email() , loginRequest.password())
        );
            Users user = (Users) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        Session session = Session.builder()
                .token(token)
                .userid(user.getUser_id())
                .build();
            Optional<Roles> role = roleRepository.findById(user.getRole_id()) ;
        logger.info("USER ID: {}", user.getUser_id());

        sessionRepository.save(session);
        return new LoginResponse(
                200,
                "Login Successful",
                        role.map(Roles::getRole_name).orElse(""),
                true,
                token
        );
    }

}
