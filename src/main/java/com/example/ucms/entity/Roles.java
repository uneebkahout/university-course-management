package com.example.ucms.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Roles")  // Exact match with DB table name
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id") // Explicit column mapping
    private int role_id;
    @Column(name = "role_name") // Explicit column mapping
    private String role_name;
}