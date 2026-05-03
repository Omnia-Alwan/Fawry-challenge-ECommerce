import dummyData.ExpireDummy;
import dummyData.ShipDummy;
import dummyData.bothDummy;
import dummyData.productDummy;
import entities.customer;
import entities.product;
import entities.expireableItems;
import entities.ShippableItems;
import entities.ShippableAndExpirableItems;
import process.checkOut;
import process.shoppingCart;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static shoppingCart shoppingCartt= new shoppingCart();
    public static customer c=new customer("Omnia","Ashmoon","01201654713",3000);
    public static void main(String[] args) {

        System.out.println("Hello in Omnia E-commerce, where you find all you need!!");
        fillShoppingCart();
        checkOut co=new checkOut(c,shoppingCartt);
        co.validateProducts();
        co.checkout();
    }
    public static void fillShoppingCart(){
        for(product p: productDummy.getProducts()){
            shoppingCartt.addProducts(p,1);
        }
        for(expireableItems p: ExpireDummy.getProducts()){
            shoppingCartt.addProducts(p,2);
        }
        for(ShippableAndExpirableItems p: bothDummy.getProducts()){
            shoppingCartt.addProducts(p,3);
        }
        for(ShippableItems p: ShipDummy.getProducts()){
            shoppingCartt.addProducts(p,3);
        }
    }
}