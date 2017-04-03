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
 * Created by sanjidagafur on 02/04/2017.
 */
class CartServiceSpec extends Specification {

    CartService cartService

    Item item1 = itemBuilder().withItemCode(BEAN).withPrice("1").withUnitCode(CAN).build()
    Item item2 = itemBuilder().withItemCode(APPLE).withPrice("3").withUnitCode(KILO).build()
    CartItem cartItem1 = cartItemBuilder().withItem(item1).withQuantity(3).build()
    CartItem cartItem2 = cartItemBuilder().withItem(item2).withQuantity(5).build()

    List<CartItem> cartItemList = [cartItem1, cartItem2]


    def setup(){
        cartService = new CartService(cartItemList)
    }

    def 'getCartItemList should return the list of cart items'(){
        when:
            def result = cartService.getCartItemList()

        then:
            result == cartItemList

    }



}
