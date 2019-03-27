package com.homework.controller;


import com.homework.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserDetails(@CookieValue("MMUSERID") String userId,@CookieValue("MMAUTHTOKEN") String userToken){

        String apiUrl = "http://mattermost.office.ponte.hu/api/v4/users/"+userId;
        ResponseEntity<String> apiResponse = userService.getRequestToAPI(apiUrl,userToken);

        return apiResponse;
    }
    @GetMapping("/team")
    public ResponseEntity<?> getTeams(@CookieValue("MMAUTHTOKEN") String userToken){

        String apiUrl = "http://mattermost.office.ponte.hu/api/v4/users/"+userToken+"/teams";
        ResponseEntity<String> responseTeams = userService.getRequestToAPI(apiUrl,userToken);

        return responseTeams;
    }

}
