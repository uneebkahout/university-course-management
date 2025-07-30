package com.example.ucms.repository;

import com.example.ucms.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
}
