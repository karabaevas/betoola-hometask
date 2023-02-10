package com.betoola.homework.validation;

import com.betoola.homework.exception.ValidationException;
import com.betoola.homework.model.CurrencyCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Validator {
    public void validate(CurrencyCode currencyCode1, CurrencyCode currencyCode2, BigDecimal amount){
        if (amount.intValue()<=0){
            throw new ValidationException("Amount must be more than zero!");
        }
        if (currencyCode1.equals(currencyCode2)){
            throw new ValidationException("Same currency passed twice!");
        }
    };
}
