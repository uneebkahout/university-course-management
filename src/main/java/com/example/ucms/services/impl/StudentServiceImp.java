package com.example.ucms.services.impl;

import com.example.ucms.DTO.Students.StudentRequest;
import com.example.ucms.DTO.Students.StudentResponse;
import com.example.ucms.DTO.users.UserResponse;
import com.example.ucms.entity.Students;
import com.example.ucms.exception.ResourceNotFoundException;
import com.example.ucms.repository.StudentRepository;
import com.example.ucms.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentServices {
    private final StudentRepository  studentRepository;

    @Override
    public void createStudent(StudentRequest request) {
        Students response = Students.builder()
                .user_id(request.user_id())
                .student_number(request.student_number())
                .gender(request.gender())
                .address(request.address())
                .date_of_birth(request.date_of_birth())
                .admission_date(request.admission_date())
                .contact_number(request.contact_number())
                .department(request.department())

                .build();
        mapToResponse(studentRepository.save(response));
    }

    @Override
    public List<StudentResponse> getStudent() {
        return studentRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    public void updateStudent(int student_id, StudentRequest request) {
      Students students =  studentRepository.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("User Not found "));
        if (request.student_number() !=null){
            students.setStudent_number(request.student_number());
        }
        if (request.address()!=null){
            students.setAddress(request.address());
        }
        if (request.date_of_birth() != null) {
            students.setDate_of_birth(request.date_of_birth());
        }
        if (request.department() !=null){
            students.setDepartment(request.department());
        }
        if (request.contact_number() !=null)
        {
            students.setContact_number(request.contact_number());
        }
        if (request.admission_date() !=null){
            students.setAdmission_date(request.admission_date());
        }
        if (request.gender()!=null){
            students.setGender(request.gender());
        }
        mapToResponse(studentRepository.save(students));
    }

    @Override
    public void deleteStudent(int student_id) {
        studentRepository.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        studentRepository.deleteById(student_id);

    }

    private StudentResponse mapToResponse(Students student){
        return  new StudentResponse(
                student.getStudent_id(),
                student.getUser_id(),
                student.getStudent_number(),
                student.getDate_of_birth(),
                student.getGender(),
                student.getDepartment(),
                student.getContact_number(),
                student.getAddress(),
                student.getAdmission_date()




        );

    }

}
