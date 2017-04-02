package org.sanjida.supermarket.code;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public enum PromotionCode {

    BUY_TWO_GET_ONE_FREE(5001, "buyTwoGetOneFree", ItemCode.APPLE),
    BUY_TWO_CAN_FOR_ONE_POUND(5002, "buyTwoCanForOnePound", ItemCode.BEAN);


    PromotionCode(int id, String promoName, ItemCode itemCode){
        this.id=id;
        this.promoName=promoName;
        this.itemCode = itemCode;
    }

    int id;
    String promoName;
    ItemCode itemCode;

    public static PromotionCode getPromotionCode(ItemCode itemCode){
        for(PromotionCode code : PromotionCode.values()){
            if(code.itemCode == itemCode){
                return code;
            }
        }
        return null;
    }



}
