package com.example.CLASE15_CLIENT_1.repository;

import com.example.CLASE15_CLIENT_1.model.clientDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepository extends JpaRepository<clientDTO, Integer> {
}
