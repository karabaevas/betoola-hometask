package com.betoola.homework.validation;

import com.betoola.homework.exception.ValidationException;
import com.betoola.homework.model.CurrencyCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Validator {
    public void validate(CurrencyCode source, CurrencyCode target, BigDecimal amount) {
        if (amount.doubleValue() <= 0) {
            throw new ValidationException("Amount must be more than zero!");
        }
        if (source.equals(target)) {
            throw new ValidationException("You are trying to convert to the same currency");
        }
    };
}
