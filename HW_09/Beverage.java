package HW_09;

import java.util.HashMap;
import java.util.Map;

import HW_09.alliance.*;
import HW_09.*;

public class Beverage extends Product {
    public Beverage(String name, double price, double quantity, double weight, double volume) {
        super(name, price, quantity, weight, volume);
    }
}

class HotBeverage extends Beverage {
    private int temperature;

    public HotBeverage(String name, double price, double quantity, double weight, double volume, int temperature) {
        super(name, price, quantity, weight, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

// Класс Food (Еда) с полем weight (масса) и методом toString()
public class Food {
    private double weight;

    public Food(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Food [weight=" + weight + "]";
    }
}
