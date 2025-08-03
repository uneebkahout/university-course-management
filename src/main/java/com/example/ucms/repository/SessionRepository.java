package com.example.ucms.repository;

import com.example.ucms.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SessionRepository extends JpaRepository<Session, UUID> {
}
