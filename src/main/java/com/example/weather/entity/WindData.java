package com.example.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindData {


        @JsonProperty("speed")
        private double windSpeed;

        // Getters and setters (Omitted for brevity)

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }


}
