package com.example.CLASE15_CLIENT_2;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "clientservice")
@LoadBalancerClient(name = "clientservice", configuration=CustomLoadBalancerConfiguration.class)
public interface IConsumer {

    @GetMapping("/getClients") //get request
    ResponseEntity<List<Object>> getApi();
}
