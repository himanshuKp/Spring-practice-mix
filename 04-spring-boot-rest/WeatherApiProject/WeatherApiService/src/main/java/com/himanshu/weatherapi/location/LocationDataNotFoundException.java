package com.himanshu.weatherapi.location;

public class LocationDataNotFoundException extends RuntimeException {
  public LocationDataNotFoundException(String message) {
    super(message);
  }
}
