package com.himanshu.weatherapi;

public class GeolocationException extends RuntimeException {
    public GeolocationException(String message) {
        super(message);
    }
    public GeolocationException(String message, Throwable cause) {
      super(message, cause);
    }
}
