package com.example.weather.controller;

import com.example.weather.entity.WeatherDataEntity;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/data")

public class WeatherController {

//    private final String baseUrl = "https://samples.openweathermap.org/data/2.5/forecast/hourly";
//    private final String apiKey = "b6907d289e10d714a6e88b30761fae22";

    @Autowired
    private RestTemplate restTemplate;
    private final WeatherService weatherService;

    public WeatherController(RestTemplate restTemplate, WeatherService weatherService) {
        this.restTemplate = restTemplate;
        this.weatherService = weatherService;
    }

    @PostMapping("/weather")
    public ResponseEntity<String> saveWeatherData(@RequestBody WeatherDataEntity weatherData) {
        try {
            WeatherDataEntity savedData = weatherService.saveWeatherData(weatherData);
            return ResponseEntity.ok("Weather data saved successfully with ID: " + savedData.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while saving weather data: " + e.getMessage());
        }
    }
    @GetMapping("/weather/{id}")
    public ResponseEntity<WeatherDataEntity> getWeatherDataById(@PathVariable Long id) {
        try {
            WeatherDataEntity weatherData = weatherService.getWeatherDataById(id);
            return ResponseEntity.ok(weatherData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
    @GetMapping("/weather/{id}/windspeed")
    public ResponseEntity<Double> getWindSpeedById(@PathVariable Long id) {
        try {
            double windSpeed = weatherService.getWindSpeedById(id);
            return ResponseEntity.ok(windSpeed);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/weather/{id}/pressure")
    public ResponseEntity<Double> getPressureById(@PathVariable Long id) {
        try {
            double pressure = weatherService.getPressureById(id);
            return ResponseEntity.ok(pressure);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
