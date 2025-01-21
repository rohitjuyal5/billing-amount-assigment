package com.example.demo.models.dto;

import com.example.demo.util.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDetailsDiscountRequestDTO {
    @NotNull
    private CustomerType customerType;
    @NotNull
    @Min(0)
    private Double purchaseAmount;
}
