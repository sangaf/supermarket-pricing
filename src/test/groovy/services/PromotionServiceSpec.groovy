package services

import org.sanjida.supermarket.code.PromotionCode
import org.sanjida.supermarket.domain.Item
import org.sanjida.supermarket.services.PromotionService
import spock.lang.Specification

import static org.sanjida.supermarket.code.ItemCode.BEAN
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

    def "getPromotion should return promotion for the item"(){
        given:
            Item item = itemBuilder().withItemCode(BEAN).withPrice("4").withPriceCode(CAN).build()
        when:
            PromotionCode promotionCode = promotionService.getPromotionCodeForItem(item)

        then:
            promotionCode == PromotionCode.BUY_TWO_CAN_FOR_ONE_POUND

    }

}
