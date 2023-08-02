package HW_09;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import HW_09.alliance.*;
import HW_09.*;

// Класс VendingMachine (Торговый автомат)
public class VendingMachine {
    protected Map<String, Product> products = new HashMap<>();

    // Метод добавления продукта в автомат
    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }
}

class HotBeverageVendingMachine extends VendingMachine {

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
}
