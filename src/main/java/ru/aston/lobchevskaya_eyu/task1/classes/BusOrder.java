package ru.aston.lobchevskaya_eyu.task1.classes;

import ru.aston.lobchevskaya_eyu.task1.enums.Route;

public class BusOrder extends Order {

    private final static Integer DISCOUNT_PERCENTAGE = 25;
    private final Route route;

    public BusOrder(User user, Long amount, Long price, Route route) {
        super(user, amount, price);
        this.route = route;
    }

    public Route getRoute() {
        return route;
    }

    @Override
    public Long getDiscount() {
        return getPrice() * getAmount() * DISCOUNT_PERCENTAGE / 100;
    }

    @Override
    public Long getDiscountedPrice() {
        return getPrice() * getAmount() - getDiscount();
    }
}