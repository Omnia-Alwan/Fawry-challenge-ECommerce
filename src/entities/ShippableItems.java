package entities;

import interfaces.Shippable;

public class ShippableItems extends product implements Shippable {

    private double weight;
    public ShippableItems(String name, double price, int amount, double weight) {
        super( name, price, amount);
        this.weight=weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {

        return weight;
    }
}
