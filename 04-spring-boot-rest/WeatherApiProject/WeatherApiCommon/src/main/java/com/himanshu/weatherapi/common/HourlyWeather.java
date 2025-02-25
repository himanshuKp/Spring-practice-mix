package com.himanshu.weatherapi.common;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "weather_hourly")
public class HourlyWeather {
    @EmbeddedId
    private HourlyWeatherId hourlyWeatherId = new HourlyWeatherId();

    private int temperature;
    private int precipitation;

    private String status;

    public HourlyWeatherId getHourlyWeatherId() {
        return hourlyWeatherId;
    }

    public void setHourlyWeatherId(HourlyWeatherId hourlyWeatherId) {
        this.hourlyWeatherId = hourlyWeatherId;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
