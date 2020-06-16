package com.spring.example.weatherapi.service.impl;

import com.spring.example.weatherapi.model.Weather;
import com.spring.example.weatherapi.repository.WeatherRepository;
import com.spring.example.weatherapi.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    //List<Weather> weatherList = new LinkedList(); replace list with repository

    WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository){
        this.weatherRepository = weatherRepository;
    }
    
    @Override
    public boolean addWeatherReadings(Weather weatherData) {
        System.out.println(weatherData);
        weatherRepository.save(weatherData);
        //weatherList.add(weatherData); // add weather data to a list
        return true;
    }

    @Override
    public List<Weather> sortWeatherReadings() {
        List<Weather> weatherList = (List<Weather>) weatherRepository.findAll();
        // to return the sorted list of weather data based on timestamp
        weatherList.sort(Comparator.comparing(Weather::getTimestamp));
        return weatherList;
    }
}
