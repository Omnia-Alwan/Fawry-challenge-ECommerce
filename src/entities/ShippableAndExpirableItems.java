package entities;

import interfaces.Expirable;
import interfaces.Shippable;

import java.time.LocalDate;

public class ShippableAndExpirableItems extends product implements Shippable, Expirable {
    private LocalDate expiryDate;
    private double weight;
    public ShippableAndExpirableItems(String name, double price, int amount, double weight, LocalDate expiryDate) {
        super( name, price, amount);
        this.expiryDate=expiryDate;
        this.weight=weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return null;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}
