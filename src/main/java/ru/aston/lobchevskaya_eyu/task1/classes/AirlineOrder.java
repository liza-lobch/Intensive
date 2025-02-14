package ru.aston.lobchevskaya_eyu.task1.classes;

import ru.aston.lobchevskaya_eyu.task1.enums.DiscountPercentage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AirlineOrder extends Order {

    private final Boolean isNewRoute;

    public AirlineOrder(User user, Long amount, BigDecimal price, Boolean isNewRoute) {
        super(user, amount, price);
        this.isNewRoute = isNewRoute;
    }

    public Boolean getNewRoute() {
        return isNewRoute;
    }

    @Override
    public BigDecimal getDiscount() {
        return isNewRoute ?
                getPrice().multiply(BigDecimal.valueOf(getAmount())).multiply(BigDecimal.valueOf(DiscountPercentage.AIRLINE_PERCENTAGE_FOR_NEW_ROUTES.getPercentage())).divide(BigDecimal.valueOf(100), RoundingMode.CEILING) :
                getPrice().multiply(BigDecimal.valueOf(getAmount())).multiply(BigDecimal.valueOf(DiscountPercentage.AIRLINE_DISCOUNT_PERCENTAGE.getPercentage())).divide(BigDecimal.valueOf(100), RoundingMode.CEILING);
    }

    @Override
    public BigDecimal getDiscountedPrice() {
        return getPrice().multiply(BigDecimal.valueOf(getAmount())).subtract(getDiscount());
    }
}