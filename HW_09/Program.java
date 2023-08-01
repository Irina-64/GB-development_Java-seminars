package HW_09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import HW_09.alliance.*;
import HW_09.*;

public class Program {
    public static void main(String[] args) {
        // Пример оформления заказа
        Order order = createOrder("John");

        // Вывод информации о заказе
        System.out.println(order);
    }

    public static Order createOrder(String customerName) {
        Order order = new Order(customerName);

        // Пример продуктов в наличии
        Product coffee = new Product("Coffee", 3.5, 2);
        Product milk = new Product("Milk", 2, 1.5);
        Product tea = new Product("Tea", 2.2, 0);

        // Добавление продуктов в заказ
        order.addProduct(coffee);
        order.addProduct(milk);
        order.addProduct(tea);

        return order;
    }
}