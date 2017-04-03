package org.sanjida.supermarket.services

import org.sanjida.supermarket.code.PromotionCode
import org.sanjida.supermarket.domain.Item
import spock.lang.Specification
import spock.lang.Unroll

import static org.sanjida.supermarket.code.ItemCode.*
import static org.sanjida.supermarket.code.PromotionCode.BUY_TWO_CAN_FOR_ONE_POUND
import static org.sanjida.supermarket.code.PromotionCode.BUY_TWO_GET_ONE_FREE
import static org.sanjida.supermarket.code.UnitCode.CAN
import static util.ItemBuilder.itemBuilder

/**
 * Created by sanjidagafur on 02/04/2017.
 */
class PromotionServiceSpec extends Specification {

    PromotionService promotionService

    def setup(){
        promotionService = new PromotionService()
    }

    @Unroll
    def "getPromotion should return promotion #promotion for the item #itemCode"(){
        given:
            Item item = itemBuilder().withItemCode(itemCode).withPrice("4").withUnitCode(CAN).build()
        when:
            PromotionCode promotionCode = promotionService.getPromotionCodeForItem(item)
        then:
            promotionCode == promotion
        where:
            itemCode | promotion
            BEAN     | BUY_TWO_CAN_FOR_ONE_POUND
            COKE     | BUY_TWO_GET_ONE_FREE
            TURNIP   | null

    }

}
