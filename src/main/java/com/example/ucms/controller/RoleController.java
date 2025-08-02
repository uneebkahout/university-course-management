package com.example.ucms.controller;

import com.example.ucms.DTO.role.roleRequest;
import com.example.ucms.DTO.role.roleResponse;
import com.example.ucms.exception.ApiErrorResponse;
import com.example.ucms.exception.ApiResponseWithData;
import com.example.ucms.exception.ApiSuccessResponse;
import com.example.ucms.services.RoleServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class RoleController {
private  final RoleServices roleServices;

@PostMapping("/api/auth/addRole")
    public ResponseEntity<ApiSuccessResponse> addRole(@Valid @RequestBody roleRequest roleRequest, HttpServletRequest request){
        roleServices.createRole(roleRequest);
    ApiSuccessResponse response = ApiSuccessResponse.builder()
            .status(HttpStatus.CREATED.value())
            .message("Role added successfully")
            .path(request.getRequestURI())
            .build();
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}

    @GetMapping("/api/auth/getAllRole")
    public ResponseEntity<List<roleResponse>> getRole(){
    return  ResponseEntity.ok(roleServices.getAllRoles());
    }



    @PutMapping("/api/updateRole/{role_id}")
    public ResponseEntity<ApiSuccessResponse> updateRole(
            @PathVariable int role_id,
            @RequestBody roleRequest request,
            HttpServletRequest servletRequest
    ) {
        roleServices.updateRole(role_id, request);

        return ResponseEntity.ok(
                ApiSuccessResponse.builder()
                        .status(200)
                        .message("Role updated successfully")
                        .path(servletRequest.getRequestURI())
                        .build()
        );
    }



    @DeleteMapping("/api/deleteRole/{role_id}")
    public  ResponseEntity<ApiSuccessResponse> deleteRole(@PathVariable int role_id, HttpServletRequest request){
        roleServices.deleteRole(role_id);
        return  ResponseEntity.ok(ApiSuccessResponse.builder()
                        .status(200)
                        .message("Role Deleted Successfully")
                        .path(request.getRequestURI())

                .build());
    }
}





