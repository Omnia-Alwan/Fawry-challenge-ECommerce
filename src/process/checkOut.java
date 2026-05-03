package process;

import entities.*;

import java.util.HashMap;
import java.util.Map;

public class checkOut {
    private shoppingCart shoppingCart;
    private customer customer;
    Map<ShippableItems,Integer> shippableItems=new HashMap<>();
    public checkOut(final customer customer, final shoppingCart shoppingCart){
        this.customer=customer;
        this.shoppingCart=shoppingCart;
    }

    public void validateProducts(){
        validateShoppingCart();
        validateProductQuantity();
        validateProductsExpiration();
        validateCustomerBalance();
    }
    private void validateShoppingCart(){
        if(shoppingCart==null||shoppingCart.get().isEmpty())
            throw new RuntimeException("cart is empty");
        int quantity=0;
        for(Map.Entry<product,Integer> entry: shoppingCart.get().entrySet()){
            quantity+=entry.getValue();
        }
        if(quantity==0) {
            throw new RuntimeException("you have to buy AT LEAST one one of this product");
        }
    }

    private void validateProductsExpiration(){
        for(Map.Entry<product,Integer> entry:shoppingCart.get().entrySet()){
            product p=entry.getKey();
            if((p instanceof expireableItems && ((expireableItems) p).isExpired())||(p instanceof ShippableAndExpirableItems && ((ShippableAndExpirableItems) p).isExpired())) {
                throw new RuntimeException("Product expired");
            }

        }
    }

    private void validateCustomerBalance(){
        double total=shoppingCart.calculateWeight()+shoppingCart.calculateSubTotal();
        if(customer.getBalance()<total)
            throw new RuntimeException("Balance less than total purchase");
    }

    private void validateProductQuantity(){
        for(Map.Entry<product,Integer>entry:shoppingCart.get().entrySet()){
            product p=entry.getKey();
            int k= entry.getValue();
            if(p.getAmount()<k){
                throw new RuntimeException("you can't buy more than available quantity");
            }
            if(k==0){
                throw new RuntimeException("you have to buy AT LEAST one one of this product");
            }
        }
    }

    public void checkout(){
        double subtotal= shoppingCart.calculateSubTotal();
        double total =shoppingCart.calculateShippingFeeS()+subtotal;
        //I don't understand why
        customer.setBalance(customer.getBalance()-total);

        //update product amount
        for(Map.Entry<product,Integer>entry: shoppingCart.get().entrySet()){
            product p=entry.getKey();
            int k=entry.getValue();
            p.setAmount(p.getAmount()-k);

            //shipping services
            if(p instanceof ShippableItems){
                shippableItems.put((ShippableItems) p,k);
            }
        }

        ShippingService shippingService= new ShippingService();
        shippingService.Shipping(shippableItems);
        //checkout receipt
        System.out.println("*** checkout receipt **");
        for(Map.Entry<product,Integer> entry: shoppingCart.get().entrySet()){
            product p=entry.getKey();
            int q=entry.getValue();

            System.out.println(q+"x "+p.getName()+" "+p.getPrice());
        }
        System.out.println("----------------------");
        System.out.println("SubTotal: "+subtotal);
        System.out.println("Shipping: "+(total-subtotal));
        System.out.println("Total: "+total);
    }
}
