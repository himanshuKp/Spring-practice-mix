package com.himanshu.weatherapi.realtime;

import com.himanshu.weatherapi.common.RealtimeWeather;
import org.springframework.data.repository.CrudRepository;

public interface RealtimeWeatherRepository extends CrudRepository<RealtimeWeather, String> {
}
