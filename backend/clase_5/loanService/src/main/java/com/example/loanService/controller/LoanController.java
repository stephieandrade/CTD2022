package com.example.loanService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class LoanController {
    private final RestTemplate restTemplate;


    @Autowired
    public LoanController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public Object getApi(){
        String url = "http://localhost:8081/getClient"; /* endpoint que queremos consultar */
        Object forObject = restTemplate.getForObject(url, Object.class);
        return forObject;
    }

}
