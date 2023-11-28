package com.example.crudproject.repository;

import com.example.crudproject.dto.StudentEnrollmentDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollmentDataRepository extends JpaRepository<StudentEnrollmentDataEntity,Long> {

    @Query("select count(se) > 0 from StudentEnrollmentEntity se where se.phoneNumber = :phoneNumber")
    boolean checkPhoneNumber(Long phoneNumber);

}
