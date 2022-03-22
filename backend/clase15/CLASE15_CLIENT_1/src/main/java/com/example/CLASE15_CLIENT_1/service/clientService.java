package com.example.CLASE15_CLIENT_1.service;


import com.example.CLASE15_CLIENT_1.model.clientDTO;
import com.example.CLASE15_CLIENT_1.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clientService {

    private final clientRepository clientRepository;

    @Autowired
    public clientService(clientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public clientDTO addClient(clientDTO client) {
        return clientRepository.save(client);
    }

    public List<clientDTO> getClients() {
        return clientRepository.findAll();
    }
}