package HW_10;

import java.util.*;

import HW_10.alliance.*;
import HW_10.*;

public abstract class Product {  
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Comparator<Product> weightComparator = Comparator.comparingDouble(Product::getWeight);
    public static Comparator<Product> volumeComparator = Comparator.comparingDouble(Product::getVolume);

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }
}
