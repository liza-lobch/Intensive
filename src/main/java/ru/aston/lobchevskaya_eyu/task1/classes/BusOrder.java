package ru.aston.lobchevskaya_eyu.task1.classes;

import ru.aston.lobchevskaya_eyu.task1.enums.DiscountPercentage;
import ru.aston.lobchevskaya_eyu.task1.enums.Route;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusOrder extends Order {

    private final Route route;

    public BusOrder(User user, Long amount, BigDecimal price, Route route) {
        super(user, amount, price);
        this.route = route;
    }

    public Route getRoute() {
        return route;
    }

    @Override
    public BigDecimal getDiscount() {
        return getPrice().multiply(BigDecimal.valueOf(getAmount())).multiply(BigDecimal.valueOf(DiscountPercentage.BUS_DISCOUNT_PERCENTAGE.getPercentage())).divide(BigDecimal.valueOf(100), RoundingMode.CEILING);
    }

    @Override
    public BigDecimal getDiscountedPrice() {
        return getPrice().multiply(BigDecimal.valueOf(getAmount())).subtract(getDiscount());
    }
}