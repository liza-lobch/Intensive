package ru.aston.lobchevskaya_eyu.task1.classes;

public class AirlineOrder extends Order {

    private final static Integer DISCOUNT_PERCENTAGE = 10;
    private final static Integer DISCOUNT_PERCENTAGE_FOR_NEW_ROUTES = 50;
    private final Boolean isNewRoute;

    public AirlineOrder(User user, Long amount, Long price, Boolean isNewRoute) {
        super(user, amount, price);
        this.isNewRoute = isNewRoute;
    }

    public Boolean getNewRoute() {
        return isNewRoute;
    }

    @Override
    public Long getDiscount() {
        return isNewRoute ? getPrice() * getAmount() * DISCOUNT_PERCENTAGE_FOR_NEW_ROUTES / 100 : getPrice() * getAmount() * DISCOUNT_PERCENTAGE / 100;
    }

    @Override
    public Long getDiscountedPrice() {
        return getPrice() * getAmount() - getDiscount();
    }
}