package com.example.ucms.services;

import com.example.ucms.DTO.Faculty.FacultyRequest;
import com.example.ucms.DTO.Faculty.FacultyResponse;

import java.util.List;

public interface FacultyServices {

    void createFaculty(FacultyRequest request);
    List<FacultyResponse> getFaculty();
    void updateFaculty(int faculty_id , FacultyRequest request);
    void deleteFaculty(int faculty_id);
}
