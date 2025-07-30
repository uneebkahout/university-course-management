package com.example.ucms.controller;


import com.example.ucms.DTO.Departments.DepartmentRequest;
import com.example.ucms.DTO.Departments.DepartmentResponse;
import com.example.ucms.DTO.users.UserResponse;
import com.example.ucms.exception.ApiResponseWithData;
import com.example.ucms.exception.ApiSuccessResponse;
import com.example.ucms.services.DepartmentServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private  final DepartmentServices departmentServices;

        @PostMapping("/api/addDepartment")
    public ResponseEntity<ApiSuccessResponse> addDepartment(@Valid @RequestBody DepartmentRequest departmentRequest , HttpServletRequest request){
        departmentServices.createDepartment(departmentRequest);
        ApiSuccessResponse response = ApiSuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .path(request.getRequestURI())
                .message("Department Added Successfully")
                .build();
        return  new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @GetMapping("/api/getDepartment")
    public ResponseEntity<ApiResponseWithData<List<DepartmentResponse>>> getDepartments(){
        List<DepartmentResponse> departmentResponses = departmentServices.getDepartments();
        ApiResponseWithData<List<DepartmentResponse>> response = ApiResponseWithData.<List<DepartmentResponse>>builder()
                .status(200)
                .message("Users fetched successfully")
                .data(departmentResponses)
                .build();

        return ResponseEntity.ok(response);

    }



    @PutMapping("/api/updateDepartment/{department_id}")
    public ResponseEntity<ApiSuccessResponse> updateDepartment(@PathVariable int department_id , @Valid @RequestBody DepartmentRequest departmentRequest, HttpServletRequest request ){
        departmentServices.updateDepartment(department_id , departmentRequest);
        ApiSuccessResponse response  =ApiSuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Department Updated Successfully")
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(response , HttpStatus.CREATED);

    }



    @DeleteMapping("/api/deleteDepartment/{department_id}")
    public ResponseEntity<ApiSuccessResponse> deleteDepartment(@PathVariable int department_id){
        departmentServices.deleteDepartment(department_id);
        ApiSuccessResponse response  =ApiSuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Department Deleted Successfully")
                .build();
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }


}
