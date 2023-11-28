package com.example.crudproject.controller;

import com.example.crudproject.dao.StudentEnrollmentData;
import com.example.crudproject.service.StudentEnrollmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class StudentEnrollmentDataController {

    @Autowired
    private StudentEnrollmentDataService studentEnrollmentDataService;

    @PostMapping("/saveAllData")
    public ResponseEntity<String> saveAllData(@RequestBody StudentEnrollmentData studentEnrollmentData){
        String response = studentEnrollmentDataService.saveAllData(studentEnrollmentData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
