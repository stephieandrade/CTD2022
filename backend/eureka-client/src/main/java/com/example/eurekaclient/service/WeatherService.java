package com.example.eurekaclient.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherService implements IWeatherService {
    @Override
    public double temperature(String city, String country) {
        return Math.random();
    }
}
