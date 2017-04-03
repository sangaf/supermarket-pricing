package util

import org.sanjida.supermarket.domain.CartItem
import org.sanjida.supermarket.domain.Item

/**
 * Created by sanjidagafur on 02/04/2017.
 */
class CartItemBuilder {

    Item item
    Double quantity

    public static CartItemBuilder cartItemBuilder(){
        return new CartItemBuilder()
    }

    public CartItemBuilder withItem(Item item){
        this.item = item
        this
    }

    public CartItemBuilder withQuantity(Double quantity){
        this.quantity = quantity
        this
    }


    public CartItem build(){
        new CartItem(this.item, this.quantity)
    }

}
