import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private double quantity;

    public Product(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}

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

public class Main {
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
