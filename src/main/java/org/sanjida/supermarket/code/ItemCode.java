package org.sanjida.supermarket.code;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public enum ItemCode {

    BEAN(1001,"bean"),
    TURNIP(2001,"turnip"),
    APPLE(3001, "apple"),
    COKE(4001, "coke");


    private ItemCode(Integer id, String itemName){
        this.id=id;
        this.itemName=itemName;
    }

    Integer id;
    String itemName;

    public Integer getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }
}
