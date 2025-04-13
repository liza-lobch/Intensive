package ru.aston.lobchevskaya_eyu.task1.enums;

public enum DiscountPercentage {

    AIRLINE_DISCOUNT_PERCENTAGE(10),
    AIRLINE_PERCENTAGE_FOR_NEW_ROUTES(50),
    BUS_DISCOUNT_PERCENTAGE(25);

    private final int percentage;

    DiscountPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "DiscountPercentage{" +
                "percentage='" + percentage + '\'' +
                '}';
    }
}
