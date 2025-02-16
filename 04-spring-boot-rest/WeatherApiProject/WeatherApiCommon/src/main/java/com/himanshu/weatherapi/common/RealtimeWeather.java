package com.himanshu.weatherapi.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "realtime_weather")
public class RealtimeWeather {
    @Id
    @Column(name = "location_code")
    private String locationCode;

    private int temperature;
    private int humidity;
    private int precipitation;
    private int windSpeed;

    @Column(length = 50)
    private String status;

    @JsonProperty("last_updated")
    private Date lastUpdated;

    @OneToOne
    @JoinColumn(name = "location_code")
    @MapsId
    private Location location;

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RealtimeWeather that)) return false;
        return temperature == that.temperature && humidity == that.humidity && precipitation == that.precipitation && windSpeed == that.windSpeed && Objects.equals(locationCode, that.locationCode) && Objects.equals(status, that.status) && Objects.equals(lastUpdated, that.lastUpdated) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationCode);
    }

    @Override
    public String toString() {
        return "RealtimeWeather{" +
                "locationCode='" + locationCode + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", precipitation=" + precipitation +
                ", windSpeed=" + windSpeed +
                ", status='" + status + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", location=" + location +
                '}';
    }
}
