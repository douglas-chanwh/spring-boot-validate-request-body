package com.bezkoder.spring.validation.payload;

import com.bezkoder.spring.validation.exception.RequestBodyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RequestBodyValidator.class)
public @interface ValidRequestBody {
    String message() default "Request body must have at least one non-null property";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}