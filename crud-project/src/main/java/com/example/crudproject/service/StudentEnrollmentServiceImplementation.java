package com.example.crudproject.service;

import com.example.crudproject.dao.StudentEnrollment;
import com.example.crudproject.dto.StudentEnrollmentEntity;
import com.example.crudproject.repository.StudentEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StudentEnrollmentServiceImplementation implements StudentEnrollmentService {

    @Autowired
    private  StudentEnrollmentRepository studentEnrollmentRepository;

    @Override
    public String registerStudent(StudentEnrollment studentEnrollment) {

        if(!isValidateMobileNumber(studentEnrollment.getPhoneNumber())){
            return "Invalid Mobile Number";
        }
        // Convert StudentEnrollment to StudentEnrollmentEntity and save it
        StudentEnrollment entity = new StudentEnrollment();
        saveStudentEntity(entity);
        return "Registration Successful";
    }

    @Override
    public String findPassword(String firstName, String lastName) {
        String password = studentEnrollmentRepository.findByFirstAndLastName(firstName,lastName);

        if(password != null){
            return password;
        }
        return "Student Data Not Found";
    }

    @Override
    public StudentEnrollment getDataByMobile(Long phoneNumber) {
        if (!isValidateMobileNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid mobile number");
        }
        StudentEnrollmentEntity student = studentEnrollmentRepository.findByMobile(phoneNumber);
        StudentEnrollment studentEnrollment = new StudentEnrollment();
        if(student != null){
            studentEnrollment.setFirstName(student.getFirstName());
            studentEnrollment.setLastName(student.getLastName());
            studentEnrollment.setPhoneNumber(student.getPhoneNumber());
            studentEnrollment.setPassword(student.getPassword());
        }
        return studentEnrollment;
    }

    private boolean isValidateMobileNumber(Long phoneNumber) {
        if(phoneNumber == null || String.valueOf(phoneNumber).trim().isEmpty())
            return false;

        String phoneNumberRegex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(phoneNumberRegex);
        Matcher matcher = pattern.matcher(String.valueOf(phoneNumber));

        return matcher.matches();

    }

    private void saveStudentEntity(StudentEnrollment studentEnrollment) {
        StudentEnrollmentEntity entity = new StudentEnrollmentEntity();
        entity.setFirstName(studentEnrollment.getFirstName());
        entity.setLastName(studentEnrollment.getLastName());
        entity.setPhoneNumber(studentEnrollment.getPhoneNumber());
        entity.setPassword(studentEnrollment.getPassword());
    }
}
