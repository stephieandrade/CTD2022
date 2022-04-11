package com.example.CLASE15_CLIENT_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {


    private final IConsumer restConsumer; //feignclient

    @Autowired
    public ConsumerController(IConsumer restConsumer) {
        this.restConsumer = restConsumer;
    }

    @GetMapping("/")
    public Object getApi(){
        ResponseEntity<List<Object>> response = restConsumer.getApi();
        System.out.println("El puerto utilizado es: "+response.getHeaders().get("port"));
        return response.getBody();
    }
}
