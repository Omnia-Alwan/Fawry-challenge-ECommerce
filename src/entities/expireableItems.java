package entities;

import interfaces.Expirable;

import java.time.LocalDate;

public class expireableItems extends product implements Expirable {

    private LocalDate expirationDate;


    public expireableItems(String name, double price, int amount, LocalDate expirationDate) {
        super(name, price, amount);
        this.expirationDate=expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return null;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
