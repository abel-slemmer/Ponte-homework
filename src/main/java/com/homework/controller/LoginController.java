package com.homework.controller;


import com.homework.domain.dto.UserDetails;
import com.mysql.cj.xdevapi.JsonString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.homework.repository.UserRepository;
import com.homework.service.LoginService;


@RestController
@RequestMapping("/api/user")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @PostMapping("/login")
    public ResponseEntity<?> getUserDetails(@RequestBody UserDetails userDetails) {
        logger.warn("this is JSON"+ userDetails.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getSmt(){
        return new ResponseEntity(HttpStatus.OK);
    }
}
