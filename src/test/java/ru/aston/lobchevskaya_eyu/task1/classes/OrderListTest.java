package ru.aston.lobchevskaya_eyu.task1.classes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.aston.lobchevskaya_eyu.task1.enums.Route;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class OrderListTest {

    private OrderList orders;

    @BeforeEach
    public void setList() {
        User user1 = new User("Иванов", "Пётр", 20);
        User user2 = new User("Андреев", "Кирилл", 25);
        User user3 = new User("Николаев", "Андрей", 40);
        User user4 = new User("Петров", "Виктор", 35);
        User user5 = new User("Ильин", "Владислав", 27);

        Order order1 = new BusOrder(user1, 1L, new BigDecimal("2000"), Route.CITY_LINE);
        Order order2 = new BusOrder(user2, 3L, new BigDecimal("10000"), Route.BUSINESS_LINE);
        Order order3 = new AirlineOrder(user3, 1L, new BigDecimal("15000"), false);
        Order order4 = new AirlineOrder(user4, 2L, new BigDecimal("12000"), false);
        Order order5 = new AirlineOrder(user5, 2L, new BigDecimal("16000"), true);

        orders = new OrderList();
        orders.addOrder(order1);
        orders.addOrder(order2);
        orders.addOrder(order3);
        orders.addOrder(order4);
        orders.addOrder(order5);
    }

    @Test
    public void testTotalPrice() {
        BigDecimal totalPrice = orders.getTotalPrice();
        BigDecimal expected = new BigDecimal("75100");
        assertEquals(expected, totalPrice);
    }
}
