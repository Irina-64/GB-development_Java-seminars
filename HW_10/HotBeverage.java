package HW_10;

import HW_10.alliance.*;
import HW_10.*;

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
