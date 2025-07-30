package com.example.ucms.repository;

import com.example.ucms.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments , Integer> {
}
