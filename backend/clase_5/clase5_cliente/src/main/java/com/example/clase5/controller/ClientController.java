package com.example.clase5.controller;

import com.example.clase5.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("getClient")
    public Client getClient(){
        return new Client(
                1L,
                "Ricardo Fort",
                true,
                5000000
         );

        }
    }

