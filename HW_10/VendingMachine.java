package HW_10;

import java.util.*;

public class VendingMachine<T extends Product> {
    protected Map<String, T> products = new HashMap<>();

    public void addProduct(T product) {
        products.put(product.getName(), product);
    }
}

