package HW_09;

import java.util.ArrayList;
import java.util.List;

import HW_09.alliance.*;
import HW_09.*;

class Product {
    private String name;
    private double price;
    private double quantity;
    private double weight;
    private double volume;

    public Product(String name, double price, double quantity, double weight, double volume) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.volume = volume;
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

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }
}

