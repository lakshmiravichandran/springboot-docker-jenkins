package com.spring.example.weatherapi.repository;

import com.spring.example.weatherapi.model.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, String> {

}
