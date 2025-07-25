package com.example.ucms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int student_id;
    private int user_id;
    private String student_number;
    private Date date_of_birth;
    private String gender;
    private String department;
    private String contact_number;
    private String address;
    private Date admission_date;

}
