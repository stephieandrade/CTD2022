package com.example.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Value("${offer.discount:35%}")
    private String discount;

    @GetMapping("view-discounts")
    public String viewDiscounts(){
        return "Discount is " + discount;
    }
}
