package com.betoola.homework.service;

import com.betoola.homework.entity.RateId;
import com.betoola.homework.exception.EntityNotFoundException;
import com.betoola.homework.model.CurrencyCode;
import com.betoola.homework.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeService {
    private final RateRepository rateRepository;
    private BigDecimal margin;

    @Value(value = "${app.margin.percents:0}")
    private void setMargin(double margin) {
        if (margin > 100 || margin < 0) {
            log.warn("Wrong input for margin!");
            if (margin > 100) {
                margin = 100;
            }
            if (margin < 0) {
                margin = 0;
            }
        }
        this.margin = BigDecimal.valueOf((100 - margin) / 100);
    }

    public BigDecimal exchange(CurrencyCode currencyForSale, BigDecimal amountForSale, CurrencyCode currencyToBuy) {
        var rate = rateRepository.findById(new RateId(currencyForSale.name(), currencyToBuy.name()));

        if (rate.isPresent()) {
            BigDecimal afterConversion = amountForSale.multiply(rate.get().getRate());
            BigDecimal afterCommission = afterConversion.multiply(margin);
            return afterCommission.setScale(2, RoundingMode.FLOOR);
        } else {
            throw new EntityNotFoundException(String.format("Rate for %s-%s not found!", currencyForSale, currencyToBuy));
        }
    }
}
