package org.sanjida.supermarket.domain;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public class CartItem {

    Item item;
    Double quantity;

    public CartItem(Item item, Double quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public Double getQuantity() {
        return quantity;
    }
}
