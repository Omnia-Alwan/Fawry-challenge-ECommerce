package process;

import entities.ShippableAndExpirableItems;
import entities.ShippableItems;
import entities.product;
import entities.expireableItems;
import interfaces.Shippable;

import java.util.*;

public class shoppingCart {

    Map<product,Integer> products;
    double shippingFees;

    public shoppingCart(){
        products=new HashMap<>();
    }
    public Map<product,Integer> get(){
        return this.products;
    }

    public void addProducts(product p, int quantity){
        if(p.getAmount()<quantity){
            throw new RuntimeException("you can't buy more than available quantity");
        }

        if((p instanceof expireableItems && ((expireableItems) p).isExpired())||(p instanceof ShippableAndExpirableItems && ((ShippableAndExpirableItems) p).isExpired())) {
            throw new RuntimeException("Product expired");
        }

        products.put(p,quantity);
    }

    public double calculateSubTotal(){
        double subTotal=0.0;
        if(products.isEmpty())
            throw new RuntimeException("cart is empty");
        for(Map.Entry<product, Integer> entry : products.entrySet()){
            product p= entry.getKey();
            int q= entry.getValue();
            subTotal+=p.getPrice()*q;
        }
        return subTotal;
    }

    public double calculateWeight(){
        double totalWeight=0.0;
        if(products.isEmpty())
            throw new RuntimeException("cart is empty");
        for(Map.Entry<product,Integer> entry: products.entrySet()){
            product p= entry.getKey();
            int q= entry.getValue();
            if(p instanceof ShippableAndExpirableItems || p instanceof ShippableItems){
                totalWeight+=((Shippable) p).getWeight();
            }
        }
        return totalWeight;
    }

    public double calculateShippingFeeS(){
        return this.shippingFees= calculateWeight()*3;
    }
}
