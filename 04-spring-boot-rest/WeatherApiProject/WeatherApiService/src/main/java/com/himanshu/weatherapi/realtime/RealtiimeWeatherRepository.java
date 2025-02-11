package com.himanshu.weatherapi.realtime;

import com.himanshu.weatherapi.common.RealtimeWeather;
import org.springframework.data.repository.CrudRepository;

public interface RealtiimeWeatherRepository extends CrudRepository<RealtimeWeather, String> {
}
