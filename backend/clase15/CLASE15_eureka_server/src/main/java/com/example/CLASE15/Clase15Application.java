package com.example.CLASE15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Clase15Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase15Application.class, args);
	}

}
