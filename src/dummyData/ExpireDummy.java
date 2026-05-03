package dummyData;

import entities.expireableItems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpireDummy {


    public static List<expireableItems> getProducts() {
        List<expireableItems> products=new ArrayList<>();
        products.add(new expireableItems("President Cheese", 15.0, 10, LocalDate.now().plusDays(10)));
        products.add(new expireableItems("Americana Burger", 30.0, 10, LocalDate.now().plusDays(1)));

        return products;
    }
}
