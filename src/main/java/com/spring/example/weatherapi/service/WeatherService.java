package com.spring.example.weatherapi.service;

import com.spring.example.weatherapi.model.Weather;

import java.util.List;

public interface WeatherService {
    // define methods
    boolean addWeatherReadings(Weather weatherData);
    List<Weather> sortWeatherReadings();
}
