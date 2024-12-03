package com.himanshukandpal.validators.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String courseCode;

    @Override
    public void initialize(CourseCode theCourseCode) {
        courseCode = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        return theCode == null || theCode.startsWith(courseCode);
    }
}
