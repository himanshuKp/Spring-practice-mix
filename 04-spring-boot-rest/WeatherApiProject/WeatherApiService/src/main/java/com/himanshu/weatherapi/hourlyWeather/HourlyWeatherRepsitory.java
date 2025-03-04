package com.himanshu.weatherapi.hourlyWeather;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.himanshu.weatherapi.common.HourlyWeather;
import com.himanshu.weatherapi.common.HourlyWeatherId;

public interface HourlyWeatherRepsitory extends CrudRepository<HourlyWeather, HourlyWeatherId> {

  @Query("""
        SELECT l from HourlyWeather l WHERE l.hourlyWeatherId.location.code = ?1
        AND l.hourlyWeatherId.hourOfDay > ?2 
        AND l.hourlyWeatherId.location.trashed = false
      """)
  public List<HourlyWeather> findByLocationCode(String locationCode, int hourOfDay);
}
