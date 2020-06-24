package com.spring.example.weatherapi.service.impl;

import com.spring.example.weatherapi.model.WeatherAlert;
import com.spring.example.weatherapi.model.Weather;
import com.spring.example.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    //List<Weather> weatherList = new LinkedList(); replace list with repository


    RestTemplate restTemplate;
    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    
    @Override
    public boolean addWeatherReadings(Weather weatherData) {
        System.out.println(weatherData);
        //weatherRepository.save(weatherData);
        //weatherList.add(weatherData); // add weather data to a list
        // adding rules for weather alerts
        if(weatherData.getTemperature() > 25){
            WeatherAlert weatherAlert = new WeatherAlert("Sunny",weatherData);
            return restTemplate.postForObject("http://localhost:8083/addReading", weatherAlert, boolean.class);
        }
        if(weatherData.getWind().getSpeed() > 6){
            WeatherAlert weatherAlert = new WeatherAlert("Windy",weatherData);
            return restTemplate.postForObject("http://localhost:8083/addReading", weatherAlert, boolean.class);
        }
        return true;
    }

    @Override
    public List<Weather> sortWeatherReadings() {
        //List<Weather> weatherList = (List<Weather>) weatherRepository.findAll();
        // to return the sorted list of weather data based on timestamp
        //weatherList.sort(Comparator.comparing(Weather::getTimestamp));
        return null;
    }
}
