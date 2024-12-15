package com.himanshu.springbootrest.customException;

public class UnitConversionException extends Exception{
    public UnitConversionException(String message) {
        super(message);
    }
}
