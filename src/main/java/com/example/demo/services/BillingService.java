package com.example.demo.services;

import com.example.demo.models.dao.DiscountSlab;
import com.example.demo.models.dto.BillingDetailsDiscountRequestDTO;
import com.example.demo.models.dto.BillingDetailsDiscountResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    public BillingDetailsDiscountResponseDTO getBillingDiscount(BillingDetailsDiscountRequestDTO billingDetailsDiscountRequest) {
        double discountAmount = 0d, slabLowerLimit = 0d;
        List<DiscountSlab> discountSlabs = billingDetailsDiscountRequest.getCustomerType().getDiscountSlabs();
        Double purchaseAmount = billingDetailsDiscountRequest.getPurchaseAmount();

        for (DiscountSlab slab: discountSlabs) {
            if (purchaseAmount <= slabLowerLimit) break;
            discountAmount += (Math.min(purchaseAmount - slabLowerLimit, slab.getUpperLimit() - slabLowerLimit) * slab.getRate());
            slabLowerLimit = slab.getUpperLimit();
        }

        return new BillingDetailsDiscountResponseDTO(purchaseAmount - discountAmount);
    }
}
