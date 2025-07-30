package com.example.ucms.services.impl;

import com.example.ucms.DTO.Departments.DepartmentRequest;
import com.example.ucms.DTO.Departments.DepartmentResponse;
import com.example.ucms.entity.Departments;
import com.example.ucms.exception.ResourceNotFoundException;
import com.example.ucms.repository.DepartmentRepository;
import com.example.ucms.services.DepartmentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentsServiceImpl implements DepartmentServices {
    private final DepartmentRepository departmentRepository;
    @Override
    public void createDepartment(DepartmentRequest request) {
        Departments dep  = Departments.builder()
                .department_name(request.department_name())
                .head_of_department(request.head_of_department())
                .office_location(request.office_location())
                .build();

        mapToResponse(departmentRepository.save(dep));

    }

    @Override
    public List<DepartmentResponse> getDepartments() {
        return departmentRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    public void updateDepartment(int department_id, DepartmentRequest request) {
      Departments dep = departmentRepository.findById(department_id).orElseThrow(()-> new ResourceNotFoundException("User Not found"));
    dep.setDepartment_name(request.department_name());
    dep.setHead_of_department(request.head_of_department());
    dep.setOffice_location(request.office_location());
    mapToResponse(departmentRepository.save(dep));
    }

    @Override
    public void deleteDepartment(int department_id) {
        departmentRepository.findById(department_id).orElseThrow(()-> new ResourceNotFoundException("User Not found"));

        departmentRepository.deleteById(department_id);
    }

    private  DepartmentResponse mapToResponse(Departments dep){
        return  new DepartmentResponse(
                dep.getDepartment_id(),
                dep.getDepartment_name(),
                dep.getHead_of_department(),
                dep.getOffice_location()
        );
    }
}
