package com.example.demo.models.dao;

import lombok.Getter;

@Getter
public class DiscountSlab {
    final private Double upperLimit;
    final private Double rate;

    public DiscountSlab(Double upperLimit, Double rate) {
        this.upperLimit = upperLimit;
        this.rate = rate;
    }
}
