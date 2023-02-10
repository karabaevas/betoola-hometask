package com.betoola.homework.service;

import com.betoola.homework.entity.RateId;
import com.betoola.homework.exception.EntityNotFoundException;
import com.betoola.homework.model.CurrencyCode;
import com.betoola.homework.repository.RateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeService {
    private static Logger logger = LoggerFactory.getLogger(ExchangeService.class);
    private BigDecimal margin;
    @Autowired
    private RateRepository rateRepository;

    public ExchangeService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Value(value = "${app.margin.percents:0}")
    private void setMargin(double margin) {
        if (margin > 100) {
            margin = 100;
            logger.warn("Wrong input for margin!");
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
