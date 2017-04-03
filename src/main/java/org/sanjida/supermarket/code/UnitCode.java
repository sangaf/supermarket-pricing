package org.sanjida.supermarket.code;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public enum UnitCode {

    KILO("kilo"),
    BOTTLE("bottle"),
    CAN("can");

    private UnitCode(String unit){
        this.unit=unit;
    }

    String unit;

    public String getUnit() {
        return unit;
    }
}
