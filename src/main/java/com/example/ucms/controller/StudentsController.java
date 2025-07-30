package com.example.ucms.controller;

import com.example.ucms.DTO.Students.StudentRequest;
import com.example.ucms.DTO.Students.StudentResponse;
import com.example.ucms.exception.ApiResponseWithData;
import com.example.ucms.exception.ApiSuccessResponse;
import com.example.ucms.services.StudentServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentsController {
private final StudentServices studentServices;

@PostMapping("/api/addStudent")
    public ResponseEntity<ApiSuccessResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest , HttpServletRequest request){

        studentServices.createStudent(studentRequest);
    ApiSuccessResponse response = ApiSuccessResponse.builder()
            .status(HttpStatus.OK.value())
            .message("Student Added Successfully")
            .path(request.getRequestURI())
            .build();
            return new ResponseEntity<>(response , HttpStatus.CREATED);

};

@GetMapping("/api/getStudents")
public ResponseEntity<ApiResponseWithData<List<StudentResponse>>> getStudent(){
    List<StudentResponse> studentResponse = studentServices.getStudent();

    ApiResponseWithData<List<StudentResponse>> response =ApiResponseWithData.<List<StudentResponse>>builder()
            .status(200)
            .message("Record Fetched Successfully")
            .data(studentResponse)
            .build();

    return  ResponseEntity.ok(response);
}

@PutMapping("/api/updateStudent/{student_id}")
    public  ResponseEntity<ApiSuccessResponse>  updateStudent(@PathVariable int student_id , @Valid @RequestBody StudentRequest studentRequest , HttpServletRequest request) {
        studentServices.updateStudent(student_id , studentRequest);
    ApiSuccessResponse response  =ApiSuccessResponse.builder()
            .status(HttpStatus.OK.value())
            .message("Student Updated Successfully")
            .path(request.getRequestURI())
            .build();
    return new ResponseEntity<>(response , HttpStatus.CREATED);
}

@DeleteMapping("api/deleteStudent/{student_id}")

    public ResponseEntity<ApiSuccessResponse> deleteStudent(@PathVariable int student_id, HttpServletRequest request){

    studentServices.deleteStudent(student_id);
    ApiSuccessResponse response  =ApiSuccessResponse.builder()
            .status(HttpStatus.OK.value())
            .message("Student Deleted Successfully")
            .path(request.getRequestURI())
            .build();
    return new ResponseEntity<>(response , HttpStatus.CREATED);
}
















}
