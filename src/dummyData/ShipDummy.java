package dummyData;

import entities.ShippableItems;

import java.util.ArrayList;
import java.util.List;

public class ShipDummy {


    public static List<ShippableItems> getProducts() {
        List<ShippableItems> products=new ArrayList<>();

        products.add(new ShippableItems("Laptop HP", 135.0, 20, 25.0));
        products.add(new ShippableItems("FAN Toshiba", 200.0, 10, 10.0));
        return products;
    }
}
