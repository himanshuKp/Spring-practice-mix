package com.himanshu.weatherapi.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "locations")
public class Location {
    @Column(length = 12, unique = true, nullable = false)
    @Id
    @NotNull(message = "Location code cannot be null")
    @Length(min = 3, max = 12, message = "Location code must have 3-12 character")
    private String code;

    @Column(length = 128, nullable = false)
    @JsonProperty("city_name")
    @NotNull(message = "City name cannot be null")
    @Length(min = 3, max = 128, message = "City name must have 3-128 characters")
    private String cityName;

    @Column(length = 128)
    @JsonProperty("region_name")
    @Length(min = 3, max = 128, message = "Region name must have 3-128 characters")
    private String regionName;

    @Column(length = 64, nullable = false)
    @JsonProperty("country_name")
    @NotNull(message = "Country name cannot be null")
    @Length(min = 3, max = 64, message = "Country name must have 3-64 characters")
    private String countryName;

    @Column(length = 2, nullable = false)
    @JsonProperty("country_code")
    @NotNull(message = "Country code cannot be null")
    @Length(min = 2, max = 2, message = "Country code must have 2 characters")
    private String countryCode;
    private boolean enabled;
    @JsonIgnore
    private boolean trashed;

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private RealtimeWeather realtimeWeather;

    @OneToMany(mappedBy = "hourlyWeatherId.location", cascade = CascadeType.ALL)
    private List<HourlyWeather> hourlyWeatherList = new ArrayList<>();

    public Location() {
    }

    public Location(String city, String region, String countryLong, String countryShort) {
        this.cityName = city;
        this.regionName = region;
        this.countryName = countryLong;
        this.countryCode = countryShort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTrashed() {
        return trashed;
    }

    public void setTrashed(boolean trashed) {
        this.trashed = trashed;
    }

    public RealtimeWeather getRealtimeWeather() {
        return realtimeWeather;
    }

    public void setRealtimeWeather(RealtimeWeather realtimeWeather) {
        this.realtimeWeather = realtimeWeather;
    }

    public List<HourlyWeather> getHourlyWeatherList() {
        return hourlyWeatherList;
    }

    public void setHourlyWeatherList(List<HourlyWeather> hourlyWeatherList) {
        this.hourlyWeatherList = hourlyWeatherList;
    }

    public Location locationCode(String locationCode) {
        setCode(locationCode);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        return Objects.equals(code, other.code); }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString() {
        return code + " => " + cityName + ", " + (regionName != null ? regionName + ", " : "") + countryName;
    }
}
