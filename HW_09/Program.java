package HW_09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import HW_09.alliance.*;
import HW_09.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание автомата и добавление продуктов
        HotBeverageVendingMachine vendingMachine = new HotBeverageVendingMachine();
        vendingMachine.addProduct(new HotBeverage("Tea", 1.5, 10, 5, 200, 80));
        vendingMachine.addProduct(new HotBeverage("Coffee", 2, 15, 10, 250, 90));
        vendingMachine.addProduct(new Beverage("Water", 1, 20, 0, 500));

        // Запрос данных о заказчике
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        // Создание заказа
        Order order = new Order(customerName);

        // Запрос продуктов для заказа
        System.out.println("Available products:");
        for (Product product : vendingMachine.products.values()) {
            System.out.println(product.getName() + " - " + product.getQuantity());
        }
        System.out.println("Enter product name and quantity (e.g., Coffee 2), enter 'done' when finished:");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            String productName = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            Product selectedProduct = vendingMachine.products.get(productName);
            if (selectedProduct == null) {
                System.out.println("Product not available. Please try again.");
                continue;
            }

            Product productInOrder = new Product(selectedProduct.getName(), selectedProduct.getPrice(), quantity,
                    selectedProduct.getWeight(), selectedProduct.getVolume());
            order.addProduct(productInOrder);
        }

        // Запрос критерия сортировки и сортировка продуктов в заказе
        System.out.println("Sort products by: (1) Weight, (2) Volume, (3) Temperature, or (4) None");
        int sortChoice = scanner.nextInt();
        switch (sortChoice) {
            case 1:
                order.sortProducts(Product.weightComparator);
                break;
            case 2:
                order.sortProducts(Product.volumeComparator);
                break;
            case 3:
                order.sortProducts(HotBeverage.temperatureComparator);
                break;
            default:
                break;
        }

        // Проверка наличия продуктов в автомате перед оформлением заказа
        vendingMachine.validateOrder(order);

        // Вывод информации о заказе
        System.out.println(order);

        scanner.close();
    }
}
