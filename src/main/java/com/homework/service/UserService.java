package com.homework.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@Transactional
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    public ResponseEntity<String> getRequestToAPI(String apiUrl,String authToken){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+ authToken);

        HttpEntity entity = new HttpEntity(headers);

        logger.warn("User Service " );

        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET,entity, String.class);

        return responseEntity;
    }




}
