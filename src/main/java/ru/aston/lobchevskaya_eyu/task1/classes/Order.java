package ru.aston.lobchevskaya_eyu.task1.classes;

import ru.aston.lobchevskaya_eyu.task1.interfaces.Discount;

import java.math.BigDecimal;

public abstract class Order implements Discount {

    private BigDecimal price;
    private Long amount;
    private User user;

    public Order(User user, Long amount, BigDecimal price) {
        this.user = user;
        this.amount = amount;
        this.price = price;
    }

    public abstract BigDecimal getDiscount();

    public abstract BigDecimal getDiscountedPrice();

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}