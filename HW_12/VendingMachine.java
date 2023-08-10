package HW_12;

import java.util.*;

// Принцип SRP (Принцип единственной ответственности)
// Каждый класс имеет только одну причину для изменения.
public class VendingMachine<T extends Product> {
    protected Map<String, T> products = new HashMap<>();

    public void addProduct(T product) {
        products.put(product.getName(), product);
    }
}

