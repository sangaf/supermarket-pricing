package org.sanjida.supermarket.services;

import org.sanjida.supermarket.domain.CartItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public class CheckoutService {

    CartService cartService;
    PricingService pricingService;

    public CheckoutService(CartService cartService, PricingService pricingService) {
        this.cartService = cartService;
        this.pricingService=pricingService;
    }

    public BigDecimal getTotalPrice(){
        List<CartItem> cartItems = cartService.getCartItemList();
        double total = 0;

        for(CartItem cartItem : cartItems){
            BigDecimal price = pricingService.calculatePriceApplyingPromotion(cartItem);
            if(price !=null){
                total += price.doubleValue();
            }
        }

        return new BigDecimal(total);
    }
}
