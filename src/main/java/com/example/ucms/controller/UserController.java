package com.example.ucms.controller;

import com.example.ucms.DTO.users.UserRequest;
import com.example.ucms.DTO.users.UserResponse;
import com.example.ucms.exception.ApiResponseWithData;
import com.example.ucms.exception.ApiSuccessResponse;
import com.example.ucms.services.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServices userServices;


    @PostMapping("/api/auth/addUser")
    public ResponseEntity<ApiSuccessResponse> addUser(@Valid @RequestBody UserRequest userRequest, HttpServletRequest request){
        userServices.createUser(userRequest);
        ApiSuccessResponse response = ApiSuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .path(request.getRequestURI())
                .message("User Added Successfully")
                .build();
        return  new ResponseEntity<>(response , HttpStatus.CREATED);

    }

    @GetMapping("/api/auth/getUser")
    public ResponseEntity<ApiResponseWithData<List<UserResponse>>> getUser(){
          List<UserResponse> user = userServices.getAllUser();
        ApiResponseWithData<List<UserResponse>> response = ApiResponseWithData.<List<UserResponse>>builder()
                .status(200)
                .message("Users fetched successfully")
                .data(user)
                .build();

        return ResponseEntity.ok(response);

    }

    @PutMapping("/api/updateUser/{user_id}")
    public ResponseEntity<ApiSuccessResponse> updateUser(@PathVariable("user_id") int user_id ,@Valid @RequestBody UserRequest userRequest , HttpServletRequest request){
            userServices.updateUser(user_id , userRequest);
            ApiSuccessResponse response  =ApiSuccessResponse.builder()
                    .status(HttpStatus.OK.value())
                    .message("User Updated Successfully")
                    .path(request.getRequestURI())
                    .build();
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }


    @DeleteMapping("/api/deleteUser/{user_id}")
    public ResponseEntity<ApiSuccessResponse> deleteUser(@PathVariable("user_id") int user_id , HttpServletRequest request){
        userServices.deleteUser(user_id);
        ApiSuccessResponse response =ApiSuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("User Deleted Successfully")
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }






}
