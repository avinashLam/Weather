package com.example.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainData {



        @JsonProperty("temp")
        private double temperature;

        @JsonProperty("pressure")
        private double pressure;

        // Getters and setters (Omitted for brevity)

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

}
