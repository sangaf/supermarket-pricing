package org.sanjida.supermarket;

import org.sanjida.supermarket.code.ItemCode;
import org.sanjida.supermarket.code.UnitCode;
import org.sanjida.supermarket.domain.CartItem;
import org.sanjida.supermarket.domain.Item;
import org.sanjida.supermarket.services.CartService;
import org.sanjida.supermarket.services.CheckoutService;
import org.sanjida.supermarket.services.PricingService;
import org.sanjida.supermarket.services.PromotionService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public class SupermarketPricingApplication {

    public static void main(String[] args){
        Item item1 = new Item(ItemCode.COKE, new BigDecimal("1.5"), UnitCode.BOTTLE);
        Item item2 = new Item(ItemCode.APPLE, new BigDecimal("3.0"), UnitCode.KILO);
        Item item3 = new Item(ItemCode.BEAN, new BigDecimal("1"), UnitCode.CAN);

        CartService cartService = new CartService();
        cartService.addToCart(item1, 5.0);
        cartService.addToCart(item2, 1.5);
        cartService.addToCart(item3, 7.0);

        PricingService pricingService = new PricingService(new PromotionService());

        CheckoutService checkoutService=new CheckoutService(cartService, pricingService);

        System.out.println("Total price at checkout => " + checkoutService.getTotalPrice());

    }

}
