package com.example.ucms.services;


import com.example.ucms.DTO.users.UserRequest;
import com.example.ucms.DTO.users.UserResponse;

import java.util.List;

public interface UserServices {
    void createUser(UserRequest request);
    List<UserResponse> getAllUser();
    void updateUser(int user_id  , UserRequest request);
    void deleteUser(int user_id);
}
