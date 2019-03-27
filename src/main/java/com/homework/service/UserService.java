package com.homework.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;



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


        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET,entity, String.class);
        logger.warn("this is response teams"+responseEntity.getHeaders());

        return responseEntity;
    }




}
