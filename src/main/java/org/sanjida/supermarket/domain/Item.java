package org.sanjida.supermarket.domain;

import org.sanjida.supermarket.code.ItemCode;
import org.sanjida.supermarket.code.UnitCode;

import java.math.BigDecimal;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public class Item {

    ItemCode itemCode;
    BigDecimal price;
    UnitCode priceCode;


    public Item(ItemCode itemCode, BigDecimal price, UnitCode priceCode) {
        this.itemCode = itemCode;
        this.price = price;
        this.priceCode = priceCode;
    }

    public ItemCode getItemCode() {
        return itemCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public UnitCode getPriceCode() {
        return priceCode;
    }
}
