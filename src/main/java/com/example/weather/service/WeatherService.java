package com.example.weather.service;

import com.example.weather.entity.WeatherDataEntity;

public interface WeatherService {

//    double getTemperatureByDate(String date);
//
//    double getWindSpeedByDate(String date);
//
//    double getPressureByDate(String date);
    WeatherDataEntity saveWeatherData(WeatherDataEntity weatherData);
    WeatherDataEntity getWeatherDataById(Long id);
    public double getWindSpeedById(Long id);
    public double getPressureById(Long id);
    }
