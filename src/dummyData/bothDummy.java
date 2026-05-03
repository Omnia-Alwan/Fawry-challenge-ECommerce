package dummyData;

import entities.ShippableAndExpirableItems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class bothDummy {



    public static List<ShippableAndExpirableItems> getProducts() {
        List<ShippableAndExpirableItems> products=new ArrayList<>();
        products.add(new ShippableAndExpirableItems("Samsung TV", 150.0, 10, 3.0, LocalDate.now().plusDays(10)));
        products.add(new ShippableAndExpirableItems("IPhone 15", 300.0, 30, 8.0,LocalDate.now().plusDays(1)));
        return products;
    }
}
