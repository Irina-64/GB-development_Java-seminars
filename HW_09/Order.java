package HW_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import HW_09.alliance.*;
import HW_09.*;

class Order {
    private List<Product> products = new ArrayList<>();
    private double totalCost;
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void addProduct(Product product) {
        if (product.getQuantity() > 0) {
            products.add(product);
            totalCost += product.getPrice() * product.getQuantity();
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    // Метод сортировки продуктов в заказе по заданному критерию
    public void sortProducts(Comparator<Product> comparator) {
        products.sort(comparator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order for ").append(customerName).append(":").append("\n");
        for (Product product : products) {
            sb.append(product.getName()).append(": ").append(product.getQuantity()).append("\n");
        }
        sb.append("Total cost: ").append(totalCost);
        return sb.toString();
    }
}
