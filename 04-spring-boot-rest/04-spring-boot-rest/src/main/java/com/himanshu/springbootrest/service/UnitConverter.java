package com.himanshu.springbootrest.service;

import com.himanshu.springbootrest.customException.UnitConversionException;
import com.himanshu.springbootrest.entity.ConversionDetails;

public class UnitConverter {
    public static void convert(ConversionDetails conversionDetails) throws UnitConversionException {
        if(conversionDetails.getFromUnit().equalsIgnoreCase("km") &&
                conversionDetails.getToUnit().equalsIgnoreCase("miles")) {
            LengthConverter.fromKilometerToMiles(conversionDetails);
        } else if (conversionDetails.getFromUnit().equalsIgnoreCase("miles") &&
                conversionDetails.getToUnit().equalsIgnoreCase("km")) {
            LengthConverter.fromMilesToKilometers(conversionDetails);
        } else {
            throw new UnitConversionException("Unsupported details entered");
        }
    }
}
