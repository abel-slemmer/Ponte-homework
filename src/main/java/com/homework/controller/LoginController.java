package com.homework.controller;


import com.homework.domain.dto.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.homework.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> userAuthenticate(@RequestBody UserDetails userDetails) {

        String mattermostLoginUrl= "http://mattermost.office.ponte.hu/api/v4/users/login";

        ResponseEntity<String> responseEntity = loginService.loginRequest(userDetails,mattermostLoginUrl);

        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

}
