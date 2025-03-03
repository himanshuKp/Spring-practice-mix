package com.himanshu.weatherapi.hourlyWeather;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.himanshu.weatherapi.common.HourlyWeather;
import com.himanshu.weatherapi.common.HourlyWeatherId;
import com.himanshu.weatherapi.common.Location;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class HourlyWeatherRepositoryTest {
  @Autowired
  private HourlyWeatherRepsitory hourlyWeatherRepsitory;

  @Test
  public void testAdd() {
    String locaionCode = "DELHI_IND";
    int hourOfDay = 12;

    Location location = new Location().locationCode(locaionCode);

    HourlyWeather forecast1 = new HourlyWeather().hourOfDay(hourOfDay)
        .location(location)
        .precipitation(30)
        .temperature(50)
        .status("Sunny");

    HourlyWeather updatedForecast = hourlyWeatherRepsitory.save(forecast1);

    assert updatedForecast.getHourlyWeatherId().getLocation().equals(location);
    assert updatedForecast.getHourlyWeatherId().getHourOfDay() == hourOfDay;
  }
  
  @Test
  public void testDelete() {
    String locationCode = "DELHI_IND";
    int hourOfDay = 12;

    Location location = new Location().locationCode(locationCode);

    HourlyWeatherId hourlyWeatherId = new HourlyWeatherId(hourOfDay, location);
    
    hourlyWeatherRepsitory.deleteById(hourlyWeatherId);

    Optional<HourlyWeather> hourlyWeather = hourlyWeatherRepsitory.findById(hourlyWeatherId);

    assert !hourlyWeather.isPresent();
  }
}
