package com.homework.controller;


import com.homework.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<?> getUserDetails(@CookieValue("MMUSERID") String userId, @CookieValue("MMAUTHTOKEN") String userToken) {

        String apiUrl = "http://mattermost.office.ponte.hu/api/v4/users/" + userId;
        ResponseEntity<String> apiResponse = userService.getRequestToAPI(apiUrl, userToken);

        return apiResponse;
    }

    @GetMapping("/team")
    public ResponseEntity<String> getTeams(@CookieValue("MMAUTHTOKEN") String userToken) {

        String apiUrlForTeams = "http://mattermost.office.ponte.hu/api/v4/users/me/teams";
        ResponseEntity<String> responseTeams = userService.getRequestToAPI(apiUrlForTeams, userToken);
        return responseTeams;
    }

    @GetMapping("/channels/{teamId}")
    public ResponseEntity<String> getChannels(@CookieValue("MMAUTHTOKEN") String userToken, @PathVariable String teamId) {

        String apiUrlForChannels = "http://mattermost.office.ponte.hu/api/v4/users/me/teams/" + teamId + "/channels";
        ResponseEntity<String> reposeChannels = userService.getRequestToAPI(apiUrlForChannels, userToken);
        return reposeChannels;
    }

    @GetMapping("/members/{teamId}")
    public ResponseEntity<String> getMembers(@CookieValue("MMAUTHTOKEN") String userToken, @PathVariable String teamId) {

        String apiForMembers = "http://mattermost.office.ponte.hu/api/v4/users/me/teams/" + teamId + "/channels/members";
        ResponseEntity<String> reposeChannels = userService.getRequestToAPI(apiForMembers, userToken);

        return reposeChannels;
    }

    @GetMapping("/posts/{channelId}")
    public ResponseEntity<String> getPosts (@CookieValue("MMAUTHTOKEN") String userToken, @PathVariable String channelId){

        String apiForMembers = "http://mattermost.office.ponte.hu/api/v4/channels/"+ channelId +"/posts";
        ResponseEntity<String> reposeChannels = userService.getRequestToAPI(apiForMembers, userToken);

        return reposeChannels;
        }


    }
