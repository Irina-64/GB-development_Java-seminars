package HW_12;

import HW_12.alliance.*;
import HW_12.*;

import java.util.*;

// Принцип SRP (Принцип единственной ответственности)
// Каждый класс имеет только одну причину для изменения.

public class Order<T extends Product> {
    private List<T> products = new ArrayList<>();
    private double totalCost;
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void addProduct(T product) {
        if (product.getQuantity() > 0) {
            products.add(product);
            totalCost += product.getPrice() * product.getQuantity();
        }
    }

    // Принцип OCP (Принцип открытости/закрытости)
    // Класс Order закрыт для модификации и открыт для расширения.
    // Можно добавить новый функционал через наследование или композицию.

    public void sortProducts(Comparator<T> comparator) {
        products.sort(comparator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order for ").append(customerName).append(":").append("\n");
        for (T product : products) {
            sb.append(product.getName()).append(": ").append(product.getQuantity()).append("\n");
        }
        sb.append("Total cost: ").append(totalCost);
        return sb.toString();
    }
}
