package com.example.crudproject.service;

import com.example.crudproject.dao.StudentEnrollmentData;
import org.springframework.stereotype.Service;

@Service
public interface StudentEnrollmentDataService {

    String saveAllData(StudentEnrollmentData studentEnrollmentData);

}
