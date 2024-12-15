package com.himanshu.springbootrest.controller;

import com.himanshu.springbootrest.customException.UnitConversionException;
import com.himanshu.springbootrest.entity.ConversionDetails;
import com.himanshu.springbootrest.service.UnitConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unit-converter")
public class UniConverterApi {

    @PostMapping
    public ResponseEntity<ConversionDetails> convert(@RequestBody ConversionDetails conversionDetails) {
        try {
            UnitConverter.convert(conversionDetails);
        } catch (UnitConversionException e) {
            return new ResponseEntity<>(conversionDetails, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(conversionDetails, HttpStatus.OK);
    }
}
