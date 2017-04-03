package org.sanjida.supermarket.services

import org.sanjida.supermarket.domain.CartItem
import org.sanjida.supermarket.domain.Item
import spock.lang.Specification

import static org.sanjida.supermarket.code.ItemCode.APPLE
import static org.sanjida.supermarket.code.ItemCode.BEAN
import static org.sanjida.supermarket.code.UnitCode.CAN
import static org.sanjida.supermarket.code.UnitCode.KILO
import static util.CartItemBuilder.cartItemBuilder
import static util.ItemBuilder.itemBuilder

/**
 * Created by sanjidagafur on 03/04/2017.
 */
class CheckoutServiceSpec extends Specification {

    private Item item1 = itemBuilder().withItemCode(BEAN).withPrice("1").withUnitCode(CAN).build()
    private Item item2 = itemBuilder().withItemCode(APPLE).withPrice("3").withUnitCode(KILO).build()
    private CartItem cartItem1 = cartItemBuilder().withItem(item1).withQuantity(3).build()
    private CartItem cartItem2 = cartItemBuilder().withItem(item2).withQuantity(5).build()

    private List<CartItem> cartItemList = [cartItem1, cartItem2]

    CheckoutService checkoutService
    CartService cartServiceMock
    PricingService pricingServiceMock

    def setup(){
        cartServiceMock = Mock()
        pricingServiceMock = Mock()
        checkoutService=new CheckoutService(cartServiceMock, pricingServiceMock)
    }

    def 'getTotalPrice should calculate total price of items in the cart'(){
        given:
            BigDecimal priceForCartItem1 = new BigDecimal("2.0")
            BigDecimal priceForCartItem2 = new BigDecimal("15.0")
            1 * cartServiceMock.getCartItemList() >> cartItemList
            1 * pricingServiceMock.calculatePriceApplyingPromotion(cartItem1) >> priceForCartItem1
            1 * pricingServiceMock.calculatePriceApplyingPromotion(cartItem2) >> priceForCartItem2
        when:
            BigDecimal result = checkoutService.getTotalPrice()

        then:
            result == priceForCartItem1.add(priceForCartItem2)
    }



}
