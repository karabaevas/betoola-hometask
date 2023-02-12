package com.betoola.homework.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class RateId implements Serializable {
    private final String fromCurrency;
    private final String toCurrency;
}