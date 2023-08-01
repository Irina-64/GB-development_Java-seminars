package HW_09;

import java.util.HashMap;
import java.util.Map;


// Класс VendingMachine (Торговый автомат)
public class VendingMachine {
    private Map<String, Beverage> products = new HashMap<>();

    public void addProduct(String name, Beverage product) {
        products.put(name, product);
    }

    public Beverage getProduct(String name) {
        return products.get(name);
    }
}

// Класс HotBeverageVendingMachine (Горячих напитков автомат) - наследник VendingMachine
public class HotBeverageVendingMachine extends VendingMachine {
    private Map<String, HotBeverage> hotBeverages = new HashMap<>();

    public void addProduct(String name, HotBeverage hotBeverage) {
        hotBeverages.put(name, hotBeverage);
    }

    public HotBeverage getProduct(String name, double volume, int temperature) {
        HotBeverage hotBeverage = hotBeverages.get(name);
        if (hotBeverage != null && hotBeverage.getVolume() == volume && hotBeverage.getTemperature() == temperature) {
            return hotBeverage;
        }
        return null;
    }
}
