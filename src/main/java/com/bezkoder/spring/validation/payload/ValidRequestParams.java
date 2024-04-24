package com.bezkoder.spring.validation.payload;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RequestParamsValidator.class)
public @interface ValidRequestParams {
    String message() default "At least one request parameter must be provided";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}