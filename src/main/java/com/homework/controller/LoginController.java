package com.homework.controller;


import com.homework.domain.dto.UserDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.homework.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<String> userAuthenticate(@RequestBody UserDetails userDetails) {

        String apiLoginUrl= "http://mattermost.office.ponte.hu/api/v4/users/login";

       return loginService.loginRequest(userDetails,apiLoginUrl);
    }

}
