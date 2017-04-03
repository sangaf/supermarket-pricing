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
    UnitCode unitCode;


    public Item(ItemCode itemCode, BigDecimal price, UnitCode unitCode) {
        this.itemCode = itemCode;
        this.price = price;
        this.unitCode = unitCode;
    }

    public ItemCode getItemCode() {
        return itemCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public UnitCode getUnitCode() {
        return unitCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (getItemCode() != item.getItemCode()) return false;
        if (getPrice() != null ? !getPrice().equals(item.getPrice()) : item.getPrice() != null) return false;
        return getUnitCode() == item.getUnitCode();
    }

    @Override
    public int hashCode() {
        int result = getItemCode() != null ? getItemCode().hashCode() : 0;
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getUnitCode() != null ? getUnitCode().hashCode() : 0);
        return result;
    }
}
