package org.sanjida.supermarket.services

import org.sanjida.supermarket.domain.CartItem
import org.sanjida.supermarket.domain.Item
import spock.lang.Specification
import spock.lang.Unroll

import static org.sanjida.supermarket.code.ItemCode.BEAN
import static org.sanjida.supermarket.code.ItemCode.COKE
import static org.sanjida.supermarket.code.ItemCode.TURNIP
import static org.sanjida.supermarket.code.PromotionCode.BUY_TWO_GET_ONE_FREE
import static org.sanjida.supermarket.code.UnitCode.BOTTLE
import static org.sanjida.supermarket.code.UnitCode.CAN
import static org.sanjida.supermarket.code.PromotionCode.BUY_TWO_CAN_FOR_ONE_POUND
import static org.sanjida.supermarket.code.UnitCode.KILO
import static util.CartItemBuilder.cartItemBuilder
import static util.ItemBuilder.itemBuilder

/**
 * Created by sanjidagafur on 02/04/2017.
 */
class PricingServiceSpec extends Specification {

    PricingService pricingService
    PromotionService promotionServiceMock

    def setup(){
        promotionServiceMock = Mock()
        pricingService = new PricingService(promotionServiceMock)
    }

    @Unroll
    def 'should calculate the price by applying promotion buy two can for £1 for #quantity item(s) '(){
        given:
            Item item = itemBuilder().withItemCode(BEAN).withPrice("1").withUnitCode(CAN).build()
            CartItem cartItem = cartItemBuilder().withItem(item).withQuantity(quantity).build()
        and:
            1 * promotionServiceMock.getPromotionCodeForItem(item) >> BUY_TWO_CAN_FOR_ONE_POUND

        when:
            BigDecimal result = pricingService.calculatePriceApplyingPromotion(cartItem)

        then:
            result == new BigDecimal(totalPrice)
        where:
            quantity | totalPrice
            5        | "3.0"
            2        | "1.0"
            1        | "1.0"

    }

    @Unroll
    def 'should calculate the price by applying promotion buy two get one free for #quantity item(s)'(){
        given:
            Item item = itemBuilder().withItemCode(COKE).withPrice("2.5").withUnitCode(BOTTLE).build()
            CartItem cartItem = cartItemBuilder().withItem(item).withQuantity(quantity).build()
        and:
            1 * promotionServiceMock.getPromotionCodeForItem(item) >> BUY_TWO_GET_ONE_FREE

        when:
            BigDecimal result = pricingService.calculatePriceApplyingPromotion(cartItem)

        then:
            result == new BigDecimal(totalPrice)
        where:
            quantity | totalPrice
            5        | "10.0"
            3        | "5.0"
            2        | "5.0"
    }

    def 'should calculate the price where no promotion available'(){
        given:
            Item item = itemBuilder().withItemCode(TURNIP).withPrice("1.99").withUnitCode(KILO).build()
            CartItem cartItem = cartItemBuilder().withItem(item).withQuantity(2).build()
        and:
            1 * promotionServiceMock.getPromotionCodeForItem(item) >> null

        when:
            BigDecimal result = pricingService.calculatePriceApplyingPromotion(cartItem)

        then:
            result == new BigDecimal("3.98")

    }


}
