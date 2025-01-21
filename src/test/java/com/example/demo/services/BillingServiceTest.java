package com.example.demo.services;

import com.example.demo.models.dto.BillingDetailsDiscountRequestDTO;
import com.example.demo.models.dto.BillingDetailsDiscountResponseDTO;
import com.example.demo.util.enums.CustomerType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BillingServiceTest {
    @InjectMocks
    private BillingService billingService;

    @ParameterizedTest
    @MethodSource("getBillingDiscountParams")
    void getBillingDiscount(BillingDetailsDiscountRequestDTO billingDetailsDiscountRequest, Double billingAmount) {
        BillingDetailsDiscountResponseDTO actualBillingDetailsDiscountResponse = billingService.getBillingDiscount(billingDetailsDiscountRequest);
        assertEquals(billingAmount, actualBillingDetailsDiscountResponse.getBillAmount());
    }

    private static Stream<Arguments> getBillingDiscountParams() {
        return Stream.of(
                Arguments.of(new BillingDetailsDiscountRequestDTO(CustomerType.REGULAR, 5000d), 5000d),
                Arguments.of(new BillingDetailsDiscountRequestDTO(CustomerType.REGULAR, 10000d), 9500d),
                Arguments.of(new BillingDetailsDiscountRequestDTO(CustomerType.REGULAR, 15000d), 13500d),
                Arguments.of(new BillingDetailsDiscountRequestDTO(CustomerType.PREMIUM, 4000d), 3600d),
                Arguments.of(new BillingDetailsDiscountRequestDTO(CustomerType.PREMIUM, 8000d), 7000d),
                Arguments.of(new BillingDetailsDiscountRequestDTO(CustomerType.PREMIUM, 12000d), 10200d),
                Arguments.of(new BillingDetailsDiscountRequestDTO(CustomerType.PREMIUM, 20000d), 15800d));
    }
}