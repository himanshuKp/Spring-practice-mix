package com.himanshu.weatherapi.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "realtime_weather")
public class RealtimeWeather {
    @Id
    @Column(name = "location_code")
    @JsonIgnore
    private String locationCode;

    @Range(min = -60, max = 60, message = "Temperature must be in the range -60 to 60 Celsius degree")
    private int temperature;
    private int humidity;
    private int precipitation;
    private int windSpeed;

    @Column(length = 50)
    private String status;

    @JsonProperty("last_updated")
    @JsonIgnore
    private Date lastUpdated;

    @OneToOne
    @JoinColumn(name = "location_code")
    @MapsId
    @JsonIgnore
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
    public int hashCode() {
        return Objects.hash(locationCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RealtimeWeather other = (RealtimeWeather) obj;
        return Objects.equals(locationCode, other.locationCode);
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
