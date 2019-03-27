package com.homework.controller;


import com.homework.domain.dto.PostDetails;
import com.homework.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> getUserDetails(@CookieValue("MMUSERID") String userId, @CookieValue("MMAUTHTOKEN") String userToken) {

        String apiUrl = "http://mattermost.office.ponte.hu/api/v4/users/" + userId;
        return userService.getRequestToAPI(apiUrl, userToken);
    }

    @GetMapping("/team")
    public ResponseEntity<String> getTeams(@CookieValue("MMAUTHTOKEN") String userToken) {

        String apiUrlForTeams = "http://mattermost.office.ponte.hu/api/v4/users/me/teams";
        return userService.getRequestToAPI(apiUrlForTeams, userToken);
    }

    @GetMapping("/channels/{teamId}")
    public ResponseEntity<String> getChannels(@CookieValue("MMAUTHTOKEN") String userToken, @PathVariable String teamId) {

        String apiUrlForChannels = "http://mattermost.office.ponte.hu/api/v4/users/me/teams/" + teamId + "/channels";
        return userService.getRequestToAPI(apiUrlForChannels, userToken);

    }

    @GetMapping("/members/{teamId}")
    public ResponseEntity<String> getMembers(@CookieValue("MMAUTHTOKEN") String userToken, @PathVariable String teamId) {

        String apiForMembers = "http://mattermost.office.ponte.hu/api/v4/users/me/teams/" + teamId + "/channels/members";
        return userService.getRequestToAPI(apiForMembers, userToken);
    }

    @GetMapping("/posts/{channelId}")
    public ResponseEntity<String> getChannelPosts(@CookieValue("MMAUTHTOKEN") String userToken, @PathVariable String channelId) {

        String apiForMembers = "http://mattermost.office.ponte.hu/api/v4/channels/" + channelId + "/posts";
        return userService.getRequestToAPI(apiForMembers, userToken);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<String> getPostById(@CookieValue("MMAUTHTOKEN") String userToken, @PathVariable String postId) {

        String apiForMembers = "http://mattermost.office.ponte.hu/api/v4/posts/" + postId;
        return userService.getRequestToAPI(apiForMembers, userToken);

    }

    @PostMapping("/createPost")
    public ResponseEntity<?> createPost(@CookieValue("MMAUTHTOKEN") String userToken,@RequestBody PostDetails postDetails ){

        String createPostUrl= "http://mattermost.office.ponte.hu/api/v4/posts";

        ResponseEntity<String> responseEntity = userService.createPostRequest(postDetails,createPostUrl,userToken);

        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }


}
