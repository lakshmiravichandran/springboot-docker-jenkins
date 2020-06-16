package com.spring.example.weatherapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.example.weatherapi.model.Weather;
import com.spring.example.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    // trying object mapper
    private ObjectMapper objectMapper;

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    // constructor
    /*public WeatherController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }*/

    @GetMapping("/simpleGet")
    public String simpleGetMethod() {
        return "Trying get method";
    }

    @PostMapping("/addReading")
    public boolean postWeatherReadings(@RequestBody Weather weatherData){
        weatherService.addWeatherReadings(weatherData);
        return true;
    }
    // trying object mapper and json node - returning inline instead of service
    /*public boolean postWeatherReadings(@RequestBody JsonNode weatherJson) throws JsonProcessingException {
        // comparing object mapper and json node
        Weather weatherObjectMapper = objectMapper.readValue(weatherJson.toString(),Weather.class);
        System.out.println(weatherObjectMapper);
        System.out.println(weatherJson); // returns json
        return true; //returns true when the reading is added to the DB
    }*/

    @GetMapping("/sortedReadings")
    public List<Weather> getSortedWeatherReadings(){
        return weatherService.sortWeatherReadings();
    }
}
