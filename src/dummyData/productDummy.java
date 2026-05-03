package dummyData;

import entities.product;

import java.util.ArrayList;
import java.util.List;

public class productDummy {


    public static List<product> getProducts() {
        List<product>products=new ArrayList<>();
        products.add(new product("Camera LG", 15.0, 10));
        products.add(new product("Bed", 30.0, 10));
        return products;
    }
}
