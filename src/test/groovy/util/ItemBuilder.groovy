package util

import org.sanjida.supermarket.code.ItemCode
import org.sanjida.supermarket.code.UnitCode
import org.sanjida.supermarket.domain.Item

/**
 * Created by sanjidagafur on 02/04/2017.
 */
class ItemBuilder {

    ItemCode itemCode
    BigDecimal price
    UnitCode priceCode

    public static ItemBuilder itemBuilder(){
        return new ItemBuilder()
    }

    public ItemBuilder withItemCode(ItemCode itemCode){
        this.itemCode = itemCode
        this
    }

    public ItemBuilder withPrice(String price){
        this.price = new BigDecimal(price)
        this
    }

    public ItemBuilder withPriceCode(UnitCode priceCode){
        this.priceCode = priceCode
        this
    }


    public Item build(){
        new Item(this.itemCode, this.price, this.priceCode)
    }



}
