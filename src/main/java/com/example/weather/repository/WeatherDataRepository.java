package com.example.weather.repository;

import com.example.weather.entity.WeatherDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherDataEntity, Long> {
}
