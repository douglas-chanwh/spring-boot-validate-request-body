package com.bezkoder.spring.validation.payload;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class RequestParamsValidator implements ConstraintValidator<ValidRequestParams, Object[]> {

    @Override
    public boolean isValid(Object[] parameters, ConstraintValidatorContext context) {
        if (parameters == null || parameters.length == 0) {
            return false;
        }

        for (Object parameter : parameters) {
            if (parameter != null) {
                return true;
            }
        }

        return false;
    }
}