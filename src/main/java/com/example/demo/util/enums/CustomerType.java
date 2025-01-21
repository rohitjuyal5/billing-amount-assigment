package com.example.demo.util.enums;

import com.example.demo.models.dao.DiscountSlab;

import java.util.Arrays;
import java.util.List;

public enum CustomerType {
    REGULAR(Arrays.asList(
            new DiscountSlab(5000d, 0.0),
            new DiscountSlab(10000d, 0.10),
            new DiscountSlab(Double.MAX_VALUE, 0.20)
    )),
    PREMIUM(Arrays.asList(
            new DiscountSlab(4000d, 0.10),
            new DiscountSlab(8000d, 0.15),
            new DiscountSlab(12000d, 0.20),
            new DiscountSlab(Double.MAX_VALUE, 0.30)
    ));

    private final List<DiscountSlab> discountSlabs;

    CustomerType(List<DiscountSlab> discountSlabs) {
        this.discountSlabs = discountSlabs;
    }

    public List<DiscountSlab> getDiscountSlabs() {
        return this.discountSlabs;
    }
}
