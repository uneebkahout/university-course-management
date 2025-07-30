package com.example.ucms.services.impl;

import com.example.ucms.DTO.users.UserRequest;
import com.example.ucms.DTO.users.UserResponse;
import com.example.ucms.config.SecurityConfiguration;
import com.example.ucms.entity.Users;
import com.example.ucms.exception.ResourceNotFoundException;
import com.example.ucms.repository.UserRepository;
import com.example.ucms.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void createUser(UserRequest request) {
        String hashPassword = passwordEncoder.encode(request.password_hash());
        Users user = Users.builder()
                .email(request.email())
                .full_name(request.full_name())
                .role_id(request.role_id())
                .password_hash(hashPassword)
                .build();

            mapToResponse(userRepository.save(user));

    }

    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    public void updateUser(int user_id, UserRequest request) {
        Users user = userRepository.findById(user_id).orElseThrow(() -> new
                ResourceNotFoundException("User Not found")
                );
        if(request.email() !=null){
            user.setEmail(request.email());
        }
        if (request.full_name()!=null){
            user.setFull_name(request.full_name());
        }
        if (request.password_hash() !=null){
            user.setPassword_hash(request.password_hash());
        }
        user.setRole_id(request.role_id());
        mapToResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(int user_id) {
         userRepository.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("User Not found"));
        userRepository.deleteById(user_id);
    }


    private  UserResponse mapToResponse(Users user){
        return  new UserResponse(
                user.getUser_id(),
                user.getFull_name(),
                user.getEmail(),
                user.getPassword_hash(),
                user.getRole_id()
        );
    }
}
