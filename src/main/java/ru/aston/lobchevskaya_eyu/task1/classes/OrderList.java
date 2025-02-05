package ru.aston.lobchevskaya_eyu.task1.classes;

import ru.aston.lobchevskaya_eyu.task1.interfaces.OrderCalculation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderList implements OrderCalculation {

    private List<Order> orders;

    public OrderList() {
        this.orders = new ArrayList();
    }

    public OrderList addOrder(Order order) {
        this.orders.add(order);
        return this;
    }

    public Long getTotalPrice() {
        Long totalSum = 0L;
        for (Order order : orders) {
            totalSum += order.getDiscountedPrice();
        }
        return totalSum;
    }

    public List<Order> sortOrderListBySurname() {
        Comparator<Order> comparator = Comparator.comparing((order) -> order.getUser().getSurname());
        comparator = comparator.thenComparing((order) -> order.getUser().getName());
        orders.sort(comparator);
        return orders;
    }

    @Override
    public String toString() {
        String str = "";
        for (Order order : orders) {
            str += String.format(""" 
                                       
                    Пользователь: %s лет
                    Вид транспорта: %s
                    %s
                    Стоимость билета: %d
                    Количество билетов: %d
                    Скидка: %d
                    Сумма итого: %d
                    """,
                    order.getUser().toString(),
                    order instanceof BusOrder ? "автобус" : "самолёт",
                    order instanceof BusOrder ? "Вид маршрута: " + ((BusOrder)order).getRoute() : "Новый маршрут: " + ((AirlineOrder)order).getNewRoute(),
                    order.getPrice(),
                    order.getAmount(),
                    order.getDiscount(),
                    order.getDiscountedPrice()
                    );
        }
        return str;
    }
}
