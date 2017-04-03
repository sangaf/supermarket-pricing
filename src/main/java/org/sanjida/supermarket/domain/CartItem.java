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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem)) return false;

        CartItem cartItem = (CartItem) o;

        if (getItem() != null ? !getItem().equals(cartItem.getItem()) : cartItem.getItem() != null) return false;
        return getQuantity() != null ? getQuantity().equals(cartItem.getQuantity()) : cartItem.getQuantity() == null;
    }

    @Override
    public int hashCode() {
        int result = getItem() != null ? getItem().hashCode() : 0;
        result = 31 * result + (getQuantity() != null ? getQuantity().hashCode() : 0);
        return result;
    }
}
