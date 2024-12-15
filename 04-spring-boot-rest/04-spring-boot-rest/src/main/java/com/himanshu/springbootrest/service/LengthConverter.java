package com.himanshu.springbootrest.service;

import com.himanshu.springbootrest.entity.ConversionDetails;

public class LengthConverter {
    static void fromKilometerToMiles(ConversionDetails conversionDetails) {
        float miles = conversionDetails.getFromValue() * 0.62137f;
        conversionDetails.setToValue(miles);
    }

    static void fromMilesToKilometers(ConversionDetails conversionDetails) {
        float kilometers = conversionDetails.getFromValue() * 1.609344f;
        conversionDetails.setToValue(kilometers);
    }
}
