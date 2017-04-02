package org.sanjida.supermarket.services;

import org.sanjida.supermarket.domain.CartItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public class CartService {

    private List<CartItem> cartItemList = new ArrayList<>();

    public CartService(List<CartItem> cartItemList){
        this.cartItemList = cartItemList;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }
}
