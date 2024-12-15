package com.himanshu.springbootrest.controller;

import com.himanshu.springbootrest.customException.UnitConversionException;
import com.himanshu.springbootrest.entity.ConversionDetails;
import com.himanshu.springbootrest.service.UnitConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unit-converter")
public class UniConverterApi {

    @PostMapping
    public ConversionDetails convert(@RequestBody ConversionDetails conversionDetails) throws UnitConversionException {
        UnitConverter.convert(conversionDetails);
        return conversionDetails;
    }
}
