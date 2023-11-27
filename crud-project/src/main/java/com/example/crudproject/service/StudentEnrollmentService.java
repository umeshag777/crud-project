package com.example.crudproject.service;

import com.example.crudproject.dao.StudentEnrollment;
import org.springframework.stereotype.Service;

@Service
public interface StudentEnrollmentService {

    String registerStudent(StudentEnrollment studentEnrollment);

    String findPassword(String firstName , String lastName);

    StudentEnrollment getDataByMobile(Long phoneNumber);
}
