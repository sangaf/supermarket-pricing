package org.sanjida.supermarket.services;

import org.sanjida.supermarket.code.PromotionCode;
import org.sanjida.supermarket.domain.CartItem;

import java.math.BigDecimal;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public class PricingService {

    PromotionService promotionService;

    public PricingService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    public BigDecimal calculatePriceApplyingPromotion(CartItem cartItem){
        return null;
    }
}
