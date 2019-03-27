package com.homework.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.domain.dto.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Service
@Transactional
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    public ResponseEntity<String> loginRequest(UserDetails user, String reqUrl) {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpEntity<String> userDetailsHttpEntity = new HttpEntity<>(jsonInString, headers);

        logger.warn("Before REG sent " + userDetailsHttpEntity.getBody());
        logger.warn("Before REG sent " + userDetailsHttpEntity.getHeaders());

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(reqUrl, userDetailsHttpEntity, String.class);


        return responseEntity;
    }


}
