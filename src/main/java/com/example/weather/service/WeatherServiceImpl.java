package com.example.weather.service;

import com.example.weather.entity.WeatherDataEntity;
import com.example.weather.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {


//    private final String baseUrl = "https://samples.openweathermap.org/data/2.5/forecast/hourly";
//    private final String apiKey = "b6907d289e10d714a6e88b30761fae22";

    private final RestTemplate restTemplate;
    private final WeatherDataRepository weatherDataRepository;
    @Autowired
    public WeatherServiceImpl(WeatherDataRepository weatherDataRepository, RestTemplate restTemplate) {
        this.weatherDataRepository = weatherDataRepository;
        this.restTemplate = restTemplate;
    }
    @Override
    public WeatherDataEntity getWeatherDataById(Long id) {
        return weatherDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Weather data not found for ID: " + id));
    }

    @Override
    public double getWindSpeedById(Long id) {
        WeatherDataEntity weatherData = weatherDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Weather data not found for ID: " + id));
        return weatherData.getWindSpeed();
    }
    @Override
    public double getPressureById(Long id) {
        WeatherDataEntity weatherData = weatherDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Weather data not found for ID: " + id));
        return weatherData.getPressure();
    }

//    @Override
//    public double getTemperatureByDate(String date) {
//        return makeApiCall("temp",date);
//    }
//
//    @Override
//    public double getWindSpeedByDate(String date) {
//        return makeApiCall("wind.speed", date);
//    }
//
//    @Override
//    public double getPressureByDate(String date) {
//        return makeApiCall("pressure", date);
//    }
    @Override
    public WeatherDataEntity saveWeatherData(WeatherDataEntity weatherData) {
        return weatherDataRepository.save(weatherData);
    }
//
//    private double makeApiCall(String field, String date) {
//        String apiUrl = baseUrl + "?q=London,us&appid=" + apiKey;
//        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
//        if (response.getStatusCode().is2xxSuccessful()) {
//            String responseBody = response.getBody();
//            // Parse the JSON response and extract the required field and date
//            // You can use libraries like Jackson or Gson to parse the JSON
//            // For simplicity, let's assume you already have the parsed data.
//            // Here, you would need to extract the required field based on the date.
//            // For example, if field is "temp", you would extract the temperature for the given date.
//            // Return the extracted value here.
//            return 0.0; // Replace this with the extracted value
//        } else {
//            throw new RuntimeException("Error: Unable to fetch data from OpenWeatherMap API");
//        }
}

