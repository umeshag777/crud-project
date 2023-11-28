package com.example.crudproject.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student_enrollment_data_info")
public class StudentEnrollmentDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "phone_number", referencedColumnName = "phone_number")
    private StudentEnrollmentEntity studentEnrollmentEntity;

    @Column(name = "sslc_percentage")
    private double sslcPercentage;

    @Column(name = "puc_percentage")
    private double pucPercentage;

    @Column(name = "cet_ranking")
    private Long cetRanking;
}
