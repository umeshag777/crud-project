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
    @JoinColumns({@JoinColumn(name = "first_name", referencedColumnName = "first_name"),
    @JoinColumn(name = "last_name", referencedColumnName = "last_name")})
    private StudentEnrollmentEntity studentEnrollmentEntity;

    @Column(name = "sslc_percentage")
    private double sslcPercentage;

    @Column(name = "puc_percentage")
    private double pucPercentage;

    @Column(name = "cet_ranking")
    private Long cetRanking;
}
