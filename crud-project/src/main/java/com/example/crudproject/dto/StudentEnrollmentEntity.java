package com.example.crudproject.dto;

import lombok.Data;


import javax.persistence.*;


@Data
@Entity
@Table (name = "student_enrollment_info")
public class StudentEnrollmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "password")
    private String password;

}
