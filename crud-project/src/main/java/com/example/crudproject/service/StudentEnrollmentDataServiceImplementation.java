package com.example.crudproject.service;

import com.example.crudproject.dao.StudentEnrollment;
import com.example.crudproject.dao.StudentEnrollmentData;
import com.example.crudproject.dto.StudentEnrollmentDataEntity;
import com.example.crudproject.dto.StudentEnrollmentEntity;
import com.example.crudproject.repository.StudentEnrollmentDataRepository;
import com.example.crudproject.repository.StudentEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentEnrollmentDataServiceImplementation implements StudentEnrollmentDataService {

    @Autowired
    private StudentEnrollmentDataRepository studentEnrollmentDataRepository;

    @Autowired
    private StudentEnrollmentRepository studentEnrollmentRepository;


    @Override
    public String saveAllData(StudentEnrollmentData studentEnrollmentData) {
        if (studentEnrollmentData != null) {
            StudentEnrollment studentEnrollment = studentEnrollmentData.getStudentEnrollment();

            if (studentEnrollment != null) {
                Long phoneNumber = studentEnrollment.getPhoneNumber();

                // Check if the phone number is registered in the other database
                if (isPhoneNumberPresent(phoneNumber)) {
                    saveStudentData(studentEnrollmentData);
                    return "Data Saved Successfully";
                } else {
                    return "Phone Number is not registered in the other database";
                }
            } else {
                return "Student enrollment in the data is null";
            }
        } else {
            return "Input data is null";
        }
    }



    private void saveStudentData(StudentEnrollmentData studentEnrollmentData) {
        StudentEnrollmentDataEntity studentEnrollmentDataEntity = new StudentEnrollmentDataEntity();
        studentEnrollmentDataEntity.setSslcPercentage(studentEnrollmentData.getSslcPercentage());
        studentEnrollmentDataEntity.setPucPercentage(studentEnrollmentData.getPucPercentage());
        studentEnrollmentDataEntity.setCetRanking(studentEnrollmentData.getCetRanking());

        StudentEnrollmentEntity studentEnrollmentEntity = new StudentEnrollmentEntity();
        studentEnrollmentEntity.setPhoneNumber(studentEnrollmentData.getStudentEnrollment().getPhoneNumber());

        studentEnrollmentDataEntity.setStudentEnrollmentEntity(studentEnrollmentEntity);

        studentEnrollmentDataRepository.save(studentEnrollmentDataEntity);
    }

    private boolean isPhoneNumberPresent(Long phoneNumber) {
        return studentEnrollmentDataRepository.checkPhoneNumber(phoneNumber);
    }
}
