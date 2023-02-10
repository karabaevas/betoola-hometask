package com.betoola.homework.entity;

import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

public class RateId implements Serializable {
    private String fromCurrency;
    private String toCurrency;

    // default constructor

    public RateId() {
    }

    public RateId(String fromCurrency, String toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RateId rateId)) return false;
        return Objects.equals(fromCurrency, rateId.fromCurrency) && Objects.equals(toCurrency, rateId.toCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromCurrency, toCurrency);
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }
}