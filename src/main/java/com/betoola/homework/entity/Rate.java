package com.betoola.homework.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;

@Entity(name = "Rate")
@IdClass(RateId.class)
@Getter
@Setter
public class Rate {
    @Id
    @Column(name = "FROM_CCY")
    private String fromCurrency;

    @Id
    @Column(name = "TO_CCY")
    private String toCurrency;

    private BigDecimal rate;

}
