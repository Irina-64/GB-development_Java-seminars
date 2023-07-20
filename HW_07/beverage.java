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


// В main проинициализировать несколько Горячих напитков и Горячих напитков автомат и воспроизвести логику, заложенную в программе
public class Main {
    public static void main(String[] args) {
        Beverage coffee = new Beverage(250);
        Food sandwich = new Food(200);
        HotBeverage tea = new HotBeverage(300, 85);

        System.out.println("Beverage: " + coffee);
        System.out.println("Food: " + sandwich);
        System.out.println("HotBeverage: " + tea);

        HotBeverageVendingMachine vendingMachine = new HotBeverageVendingMachine();
        vendingMachine.addProduct("Tea", new HotBeverage(300, 85));
        vendingMachine.addProduct("Coffee", new HotBeverage(250, 80));

        HotBeverage hotTea = vendingMachine.getProduct("Tea", 300, 85);
        HotBeverage hotCoffee = vendingMachine.getProduct("Coffee", 250, 80);

        System.out.println("Hot Tea from vending machine: " + hotTea);
        System.out.println("Hot Coffee from vending machine: " + hotCoffee);
    }
}

