package com.example.ucms.services.impl;

import com.example.ucms.DTO.Faculty.FacultyRequest;
import com.example.ucms.DTO.Faculty.FacultyResponse;
import com.example.ucms.entity.Faculty;
import com.example.ucms.exception.ResourceNotFoundException;
import com.example.ucms.repository.FacultyRepository;
import com.example.ucms.services.FacultyServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyServices {
    private  final FacultyRepository facultyRepository;

    @Override
    public void createFaculty(FacultyRequest request) {
        Faculty faculty =  Faculty.builder()
                .user_id(request.user_id())
                .employee_number(request.employee_number())
                .department(request.department())
                .designation(request.designation())
                .hire_date(request.hire_date())
                .contact_number(request.contact_number())
                .office_location(request.office_location())
                .qualification(request.qualification())
                .build();

        mapToResponse(facultyRepository.save(faculty));

    }

    @Override
    public List<FacultyResponse> getFaculty() {
        return facultyRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    public void updateFaculty(int faculty_id, FacultyRequest request) {
        Faculty faculty   = facultyRepository.findById(faculty_id).orElseThrow(() -> new ResourceNotFoundException("User Not found"));
        faculty.setUser_id(request.user_id());
        faculty.setEmployee_number(request.employee_number());
        faculty.setDesignation(request.designation());
        faculty.setDepartment(request.department());
        faculty.setQualification(request.qualification());
        faculty.setContact_number(request.contact_number());
        faculty.setOffice_location(request.office_location());
        faculty.setHire_date(request.hire_date());
        mapToResponse(facultyRepository.save(faculty));
    }

    @Override
    public void deleteFaculty(int faculty_id) {
         facultyRepository.findById(faculty_id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
         facultyRepository.deleteById(faculty_id);
    }

    private FacultyResponse mapToResponse(Faculty faculty){
        return  new FacultyResponse(
                faculty.getFaculty_id(),
                faculty.getUser_id(),
                faculty.getEmployee_number(),
                faculty.getDepartment(),
                faculty.getDesignation(),
                faculty.getQualification(),
                faculty.getContact_number(),
                faculty.getOffice_location(),
                faculty.getHire_date()


        );
    }
}
