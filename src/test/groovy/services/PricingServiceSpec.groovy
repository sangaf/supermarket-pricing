package org.sanjida.supermarket.services

import org.sanjida.supermarket.domain.CartItem
import org.sanjida.supermarket.domain.Item
import spock.lang.Specification

import static org.sanjida.supermarket.code.ItemCode.BEAN
import static org.sanjida.supermarket.code.UnitCode.CAN
import static org.sanjida.supermarket.code.PromotionCode.BUY_TWO_CAN_FOR_ONE_POUND
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

    def 'calculatePriceApplyingPromotion should return the price by applying promotion buy two can for £1'(){
        given:
            Item item = itemBuilder().withItemCode(BEAN).withPrice("1").withPriceCode(CAN).build()
            CartItem cartItem = cartItemBuilder().withItem(item).withQuantity(5).build()
        and:
            1 * promotionServiceMock.getPromotionCodeForItem(item) >> BUY_TWO_CAN_FOR_ONE_POUND

        when:
            BigDecimal result = pricingService.calculatePriceApplyingPromotion(cartItem)

        then:
            result == new BigDecimal("3.0")
    }


}
