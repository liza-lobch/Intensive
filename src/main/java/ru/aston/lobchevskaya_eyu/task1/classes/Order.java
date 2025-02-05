package ru.aston.lobchevskaya_eyu.task1.classes;

import ru.aston.lobchevskaya_eyu.task1.interfaces.Discount;

public abstract class Order implements Discount {

    private Long price;
    private Long amount;
    private User user;

    public Order(User user, Long amount, Long price) {
        this.user = user;
        this.amount = amount;
        this.price = price;
    }

    public abstract Long getDiscount();

    public abstract Long getDiscountedPrice();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}