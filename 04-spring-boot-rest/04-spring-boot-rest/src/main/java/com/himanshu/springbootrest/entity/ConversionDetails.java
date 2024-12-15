package com.himanshu.springbootrest.entity;

public class ConversionDetails {
    private String fromUnit;
    private Float fromValue;
    private String toUnit;
    private Float toValue;

    public ConversionDetails(String fromUnit, Float fromValue, String toUnit, Float toValue) {
        this.fromUnit = fromUnit;
        this.fromValue = fromValue;
        this.toUnit = toUnit;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public Float getFromValue() {
        return fromValue;
    }

    public void setFromValue(Float fromValue) {
        this.fromValue = fromValue;
    }

    public String getToUnit() {
        return toUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }

    public Float getToValue() {
        return toValue;
    }

    public void setToValue(Float toValue) {
        this.toValue = toValue;
    }
}
