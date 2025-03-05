package com.himanshu.weatherapi;

public class BadRequestException extends RuntimeException{

	public BadRequestException(String message) {
		super(message);
	}
	
}
