package com.example.crudproject.controller;

import com.example.crudproject.dao.StudentEnrollment;
import com.example.crudproject.service.StudentEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class StudentEnrollmentController {

    @Autowired
    private StudentEnrollmentService studentEnrollmentService;

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentEnrollment studentEnrollment) {
        String result = studentEnrollmentService.registerStudent(studentEnrollment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findPassword")
    public ResponseEntity<String> findPassword(@RequestParam String firstName , @RequestParam String lastName){
        String result = studentEnrollmentService.findPassword(firstName,lastName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getDataByMobile")
    public ResponseEntity<StudentEnrollment> getDataByMobile(@RequestParam Long phoneNumber){
        StudentEnrollment studentEnrollment = studentEnrollmentService.getDataByMobile(phoneNumber);
        return new ResponseEntity<>(studentEnrollment,HttpStatus.OK);
    }
}
