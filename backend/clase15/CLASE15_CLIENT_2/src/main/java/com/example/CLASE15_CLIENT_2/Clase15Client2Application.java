package com.example.CLASE15_CLIENT_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Clase15Client2Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase15Client2Application.class, args);
	}

}
