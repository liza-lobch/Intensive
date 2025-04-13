package ru.aston.lobchevskaya_eyu.task1.classes;

import ru.aston.lobchevskaya_eyu.task1.interfaces.OrderCalculation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderList implements OrderCalculation {

    private List<Order> orders;

    public OrderList() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public BigDecimal getTotalPrice() {
        return orders.stream().map(Order::getDiscountedPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void sortOrderListBySurname() {
        Comparator<Order> comparator = Comparator.comparing((order) -> order.getUser().getSurname());
        comparator = comparator.thenComparing((order) -> order.getUser().getName());
        orders = orders.stream().sorted(comparator).toList();
    }

    public String getOrders() {
        StringBuilder str = new StringBuilder();
        for (Order order : orders) {
            str.append(String.format("""
                            Пользователь: %s лет
                            Вид транспорта: %s
                            %s
                            Стоимость билета: %s
                            Количество билетов: %d
                            Скидка: %s
                            Сумма итого: %s
                            
                            """,
                    order.getUser().toString(),
                    order instanceof BusOrder ? "автобус" : "самолёт",
                    order instanceof BusOrder ? "Вид маршрута: " + ((BusOrder) order).getRoute() : "Новый маршрут: " + ((AirlineOrder) order).getNewRoute(),
                    order.getPrice(),
                    order.getAmount(),
                    order.getDiscount(),
                    order.getDiscountedPrice()
            ));
        }
        return str.toString();
    }
}