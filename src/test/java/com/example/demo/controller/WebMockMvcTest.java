package com.example.demo.controller;

import com.example.demo.controllers.BillingController;
import com.example.demo.models.dto.BillingDetailsDiscountRequestDTO;
import com.example.demo.models.dto.BillingDetailsDiscountResponseDTO;
import com.example.demo.services.BillingService;
import com.example.demo.util.enums.CustomerType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(BillingController.class)
public class WebMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillingService billingService;

    @Test
    void getBillingAmount() throws Exception {
        ObjectMapper om = new ObjectMapper();
        BillingDetailsDiscountRequestDTO billingDetailsDiscountRequestDTO = new BillingDetailsDiscountRequestDTO();
        billingDetailsDiscountRequestDTO.setCustomerType(CustomerType.REGULAR);
        billingDetailsDiscountRequestDTO.setPurchaseAmount(10000d);

        BillingDetailsDiscountResponseDTO billingDetailsDiscountResponse = new BillingDetailsDiscountResponseDTO(9500d);
        Mockito.when(billingService.getBillingDiscount(Mockito.any())).thenReturn(billingDetailsDiscountResponse);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/billing/v1/discount-details")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(billingDetailsDiscountRequestDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(om.writeValueAsString(billingDetailsDiscountResponse)));
    }
}
