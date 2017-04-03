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
        PromotionCode promotionCode = getPromotionCodeForItem(cartItem);

        if(promotionCode==null) {
            return cartItem.getItem().getPrice().multiply(new BigDecimal(cartItem.getQuantity()));
        }

        return getPrice(cartItem, promotionCode);

    }

    private BigDecimal getPrice(CartItem cartItem, PromotionCode promotionCode) {
        switch(promotionCode){
            case BUY_TWO_CAN_FOR_ONE_POUND:
                return getTotalCanPrice(cartItem);
            case BUY_TWO_GET_ONE_FREE:
                return getTotalItemPrice(cartItem);
            default:
                return cartItem.getItem().getPrice().multiply(new BigDecimal(cartItem.getQuantity()));
        }
    }

    private PromotionCode getPromotionCodeForItem(CartItem cartItem) {
        return promotionService.getPromotionCodeForItem(cartItem.getItem());
    }


    private BigDecimal getTotalCanPrice(CartItem cartItem){
        if(cartItem.getQuantity() >= 2){
            double canPrice = (Math.floor(cartItem.getQuantity()/2)) * 1 + ((cartItem.getQuantity() % 2) * cartItem.getItem().getPrice().doubleValue());
            return new BigDecimal(canPrice);
        }
        return new BigDecimal(cartItem.getQuantity() * cartItem.getItem().getPrice().doubleValue());
    }

    private BigDecimal getTotalItemPrice(CartItem cartItem){
        if(cartItem.getQuantity() >= 3){
            double actualQuantityToBeCharged = getActualQuantity(cartItem.getQuantity());
            return new BigDecimal(actualQuantityToBeCharged * cartItem.getItem().getPrice().doubleValue());
        }
        return new BigDecimal(cartItem.getQuantity() * cartItem.getItem().getPrice().doubleValue());
    }

    private double getActualQuantity(double quantity){
        double count = 2 ;
        for(double i =3; i<= quantity; i++){
            if(i%3 != 0){
                count++;
            }
        }

        return count;
    }
}
