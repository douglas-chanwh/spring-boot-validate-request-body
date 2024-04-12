package com.bezkoder.spring.validation.exception;

import com.bezkoder.spring.validation.payload.ValidRequestBody;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class RequestBodyValidator implements ConstraintValidator<ValidRequestBody, Object> {
    @Override
    public boolean isValid(Object requestBody, ConstraintValidatorContext context) {
        if (requestBody == null) {
            return true;
        }

        Field[] fields = requestBody.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(requestBody) != null) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                // Handle the exception
            }
        }
        return false;
    }
}