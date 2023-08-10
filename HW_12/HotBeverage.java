package HW_12;

import HW_12.alliance.*;
import HW_12.*;

// Принцип SRP (Принцип единственной ответственности)
// Каждый класс имеет только одну причину для изменения.

public class HotBeverage extends Beverage {
    private int temperature;

    public HotBeverage(String name, double price, double quantity, double weight, double volume, int temperature) {
        super(name, price, quantity, weight, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
