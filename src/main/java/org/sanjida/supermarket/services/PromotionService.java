package org.sanjida.supermarket.services;

import org.sanjida.supermarket.code.PromotionCode;
import org.sanjida.supermarket.domain.Item;

/**
 * Created by sanjidagafur on 02/04/2017.
 */
public class PromotionService {

    public PromotionCode getPromotionCodeForItem(Item item){

        return PromotionCode.getPromotionCode(item.getItemCode());

    }


}
