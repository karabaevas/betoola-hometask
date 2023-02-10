package com.betoola.homework.controller;

import com.betoola.homework.api.ExchangeApi;
import com.betoola.homework.model.CurrencyCode;
import com.betoola.homework.service.ExchangeService;
import com.betoola.homework.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ExchangeController implements ExchangeApi {
    private final ExchangeService exchangeService;
    private final Validator validator;
    public ExchangeController(ExchangeService exchangeService, Validator validator) {
        this.exchangeService = exchangeService;
        this.validator = validator;
    }

    @Override
    public ResponseEntity<String> exchange(@NonNull CurrencyCode currencyForSale,
                                           @NonNull BigDecimal amountForSale,
                                           @NonNull CurrencyCode targetCurrency) {
        validator.validate(currencyForSale, targetCurrency, amountForSale);
        return ResponseEntity.ok(exchangeService.exchange(currencyForSale, amountForSale, targetCurrency).toPlainString());
    }
}
