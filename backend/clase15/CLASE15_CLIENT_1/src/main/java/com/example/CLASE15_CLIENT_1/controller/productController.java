package com.example.CLASE15_CLIENT_1.controller;

import com.example.CLASE15_CLIENT_1.model.clientDTO;
import com.example.CLASE15_CLIENT_1.service.clientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productController {

    private final clientService clientService;

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    public productController(clientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/addClient")
    public void addClient(@RequestBody clientDTO client){
        clientService.addClient(client);
    }

        @GetMapping("/getClients")
    public List<clientDTO> getClients(){
        return clientService.getClients();
    }
}
