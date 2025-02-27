package com.himanshu.weatherapi.hourlyWeather;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.himanshu.weatherapi.common.HourlyWeather;
import com.himanshu.weatherapi.common.HourlyWeatherId;

@Repository
public interface HourlyWeatherRepsitory extends JpaRepository<HourlyWeather, HourlyWeatherId>{
  
}
