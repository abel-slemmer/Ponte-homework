package com.homework.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.domain.dto.PostDetails;
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

        return restTemplate.exchange(apiUrl, HttpMethod.GET,entity, String.class);

    }


    public ResponseEntity<String> createPostRequest(PostDetails postDetails, String reqUrl, String authToken) {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+ authToken);

        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(postDetails);
        } catch (JsonProcessingException e) {
             logger.warn("Json transform error: "+e);
        }

        HttpEntity<String> userDetailsHttpEntity = new HttpEntity<>(jsonInString, headers);

        return restTemplate.postForEntity(reqUrl, userDetailsHttpEntity, String.class);
    }




}
