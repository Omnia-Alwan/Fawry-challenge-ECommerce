package process;

import entities.ShippableAndExpirableItems;
import entities.ShippableItems;
import entities.product;

import java.util.*;

public class ShippingService {

    /*** Shipment notice **
            2x Cheese 400g
            1x Biscuits 700g
            Total package weight 1.1kg*/
    public void Shipping(Map<ShippableItems,Integer> shoppingCart){
        //shoppingCart shoppingCart= new shoppingCart();
        double weight=0.0;
        System.out.println("*** Shipment notice **");
        for(Map.Entry<ShippableItems,Integer> entry: shoppingCart.entrySet()){
            ShippableItems p=entry.getKey();
            int q=entry.getValue();
            weight+= p.getWeight()*q;

            System.out.println(q+"x "+p.getName()+" "+p.getWeight()+"kg");
        }
        System.out.println("Total package weight "+weight+"kg");
    }
}
