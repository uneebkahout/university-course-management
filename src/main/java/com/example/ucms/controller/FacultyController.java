package com.example.ucms.controller;

import com.example.ucms.DTO.Faculty.FacultyRequest;
import com.example.ucms.DTO.Faculty.FacultyResponse;
import com.example.ucms.DTO.Students.StudentRequest;
import com.example.ucms.exception.ApiResponseWithData;
import com.example.ucms.exception.ApiSuccessResponse;
import com.example.ucms.services.FacultyServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FacultyController {
    private  final FacultyServices facultyServices;


    @PostMapping("/api/addFaculty")
    public ResponseEntity<ApiSuccessResponse> addFaculty(@Valid @RequestBody FacultyRequest facultyRequest, HttpServletRequest request){
        facultyServices.createFaculty(facultyRequest);
        ApiSuccessResponse response = ApiSuccessResponse.builder()
                .status(200)
                .message("Faculty Added Successfully")
                .path(request.getRequestURI())
                .build();
        return new  ResponseEntity<>(response ,HttpStatus.CREATED);
    }

    @GetMapping("/api/getFaculty")
    public  ResponseEntity<ApiResponseWithData<List<FacultyResponse>>> getFaculty(){
        List<FacultyResponse> facultyResponses = facultyServices.getFaculty();
        ApiResponseWithData<List<FacultyResponse>>  response  = ApiResponseWithData.<List<FacultyResponse>>builder()
                .status(200)
                .message("Data Fetched Successfully")
                .data(facultyResponses)
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/api/updateFaculty/{faculty_id}")
    public  ResponseEntity<ApiSuccessResponse> updateFaculty(@PathVariable int faculty_id , @Valid @RequestBody FacultyRequest facultyRequest , HttpServletRequest request){
        facultyServices.updateFaculty(faculty_id , facultyRequest);
        ApiSuccessResponse response  =ApiSuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Faculty Updated Successfully")
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(response , HttpStatus.CREATED);


    }




    @DeleteMapping("/api/deleteFaculty/{faculty_id}")
    public ResponseEntity<ApiSuccessResponse> deleteFaculty(@PathVariable int faculty_id ){
        facultyServices.deleteFaculty(faculty_id);
        ApiSuccessResponse response  =ApiSuccessResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Faculty Deleted  Successfully")
                .build();
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }










}
