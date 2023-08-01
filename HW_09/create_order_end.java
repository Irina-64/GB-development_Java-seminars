import java.util.ArrayList;
import java.util.List;

class Product {
    // ... остальной код ...

    // Методы сравнения по различным критериям
    public static Comparator<Product> weightComparator = Comparator.comparingDouble(Product::getWeight);
    public static Comparator<Product> volumeComparator = Comparator.comparingDouble(Product::getVolume);

    // ... остальной код ...
}

class HotBeverage extends Beverage {
    // ... остальной код ...

    // Метод сравнения по температуре
    public static Comparator<HotBeverage> temperatureComparator = Comparator.comparingInt(HotBeverage::getTemperature);

    // ... остальной код ...
}

class Order {
    // ... остальной код ...

    // Метод сортировки продуктов в заказе по заданному критерию
    public void sortProducts(Comparator<Product> comparator) {
        products.sort(comparator);
    }

    // ... остальной код ...
}

class HotBeverageVendingMachine extends VendingMachine {
    // ... остальной код ...

    // Метод проверки наличия продуктов в автомате перед оформлением заказа
    public void validateOrder(Order order) {
        List<Product> productsToRemove = new ArrayList<>();

        for (Product product : order.getProducts()) {
            Product availableProduct = products.get(product.getName());
            if (availableProduct == null || availableProduct.getQuantity() < product.getQuantity()) {
                productsToRemove.add(product);
            }
        }

        order.getProducts().removeAll(productsToRemove);
    }

    // ... остальной код ...
}

