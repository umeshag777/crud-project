package com.example.crudproject.repository;

import com.example.crudproject.dto.StudentEnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollmentEntity,Long> {

    @Query("SELECT se.password FROM StudentEnrollmentEntity se WHERE se.firstName = :firstName AND se.lastName = :lastName")
    String findByFirstAndLastName(String firstName, String lastName);

    @Query("SELECT se FROM StudentEnrollmentEntity se WHERE se.phoneNumber = :phoneNumber")
    StudentEnrollmentEntity findByMobile(Long phoneNumber);

}
