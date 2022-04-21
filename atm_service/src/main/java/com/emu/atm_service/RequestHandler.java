package com.emu.atm_service;

import com.emu.atm_service.model.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RequestHandler {
    public static final String BASE_API = "http://localhost:8080/api/v1/";
    public static Object makeRequest(Class<Object> tClass , String path, String ...params){
//        String path = BASE_API + path"card?cardNumber=" + cardNumber;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> cardResponse = restTemplate.getForEntity(path, tClass);
        return cardResponse.getBody();
    }
}
