package com.himanshu.weatherapi.realtime;

import com.himanshu.weatherapi.common.RealtimeWeather;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RealtimeWeatherRepository extends CrudRepository<RealtimeWeather, String> {
    @Query("SELECT r FROM RealtimeWeather r WHERE r.location.cityName=?1 AND r.location.countryCode=?2")
    public RealtimeWeather findByCityNameAndCountryCode(String cityName, String countryCode);
}
