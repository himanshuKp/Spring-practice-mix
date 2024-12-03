package com.himanshukandpal.validators.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //    default course code
    String value() default "LUV";

    //    default error message
    String message() default "must start with LUV";

    //    default group by
    Class<?>[] groups() default {};

    //    default payloads
    Class<? extends Payload>[] payload() default {};
}
