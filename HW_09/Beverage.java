package HW_09;

import java.util.HashMap;
import java.util.Map;

// Класс Beverage (Напиток) с полем volume (объем) и методом toString()
public class Beverage {
    private double volume;

    public Beverage(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Beverage [volume=" + volume + "]";
    }
}


// Класс HotBeverage (Горячий напиток) - наследник Beverage - с дополнительным полем temperature (температура) и методом toString()
public class HotBeverage extends Beverage {
    private int temperature;

    public HotBeverage(double volume, int temperature) {
        super(volume);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "HotBeverage [volume=" + getVolume() + ", temperature=" + temperature + "]";
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


