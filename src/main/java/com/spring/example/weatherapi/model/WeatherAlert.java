package com.spring.example.weatherapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.Entity;
@Data
@AllArgsConstructor
public class WeatherAlert {
    private String alert;
    private Weather weather;

}
