package com.example.demo.controllers;

import com.example.demo.models.dto.BillingDetailsDiscountRequestDTO;
import com.example.demo.models.dto.BillingDetailsDiscountResponseDTO;
import com.example.demo.services.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/billing/v1")
public class BillingController {

    private final BillingService billingService;

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping("/discount-details")
    public BillingDetailsDiscountResponseDTO applyDiscount(@Valid @RequestBody BillingDetailsDiscountRequestDTO billingDetailsDiscountRequest) {
        return billingService.getBillingDiscount(billingDetailsDiscountRequest);
    }
}
