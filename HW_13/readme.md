### ООП.Урок 7. ООП Дизайн и Solid ч.2

Формат сдачи: ссылка на подписанный git-проект.

**Задание**

Реализовать шаблон Adapter: Включить датчик от другой компании, интерфейс которого отличается от
предыдущих, в систему. Первоначальный интерфейс MeteoSensor, адаптируем
SensorTemperature.
Можно использовать ссылку на [код:](https://github.com/DwarfPorter/OOP_Lesson7_Patterns/tree/master/Adapter)

Для адаптации датчика ST500Info к интерфейсу MeteoSensor создан класс-адаптер, который реализует интерфейс MeteoSensor и использует объект ST500Info для получения данных. Это дает возможность использовать SensorAdapter для адаптации данных от датчика ST500Info к интерфейсу MeteoSensor и сохранить их в базу данных.

(***) Доработать проект с автоматом напитков или со студентами и преподавателями
Применить архитектурные паттерны, добавить логирование.
Соблюдать принципы SOLID, паттерны проектирования.
Можно выбрать другой язык программирования, например C# или Python, если выбран язык, отличный от JAVA, то необходимо написать документ, каким образом можно запустить приложение 
(что необходимо установить, каким образом запускать и т.п.).




Код с учетом принципов SOLID:

```
// Принцип SRP (Принцип единственной ответственности)
// Каждый класс имеет только одну причину для изменения.

// Product.java
public abstract class Product {
    // ... код класса ...
}

// Принцип OCP (Принцип открытости/закрытости)
// Программные сущности должны быть открыты для расширения, но закрыты для модификации.

// VendingMachineService.java
public interface VendingMachineService<T extends Product> {
    void addProduct(VendingMachine<T> vendingMachine, T product);
}

// Принцип LSP (Принцип подстановки Барбары Лисков)
// Объекты в программе могут быть заменены их наследниками без изменения свойств программы.

// Beverage.java
public class Beverage extends Product {
    // ... код класса ...
}

// Food.java
public class Food extends Product {
    // ... код класса ...
}

// Принцип ISP (Принцип разделения интерфейса)
// Много специализированных интерфейсов лучше, чем один универсальный.

// VendingMachineService.java
public interface VendingMachineService<T extends Product> {
    void addProduct(VendingMachine<T> vendingMachine, T product);
}

// Принцип DIP (Принцип инверсии зависимостей)
// Зависимости должны строиться относительно абстракций, а не деталей.

// VendingMachineServiceImpl.java
public class VendingMachineServiceImpl<T extends Product> implements VendingMachineService<T> {
    @Override
    public void addProduct(VendingMachine<T> vendingMachine, T product) {
        vendingMachine.addProduct(product);
    }
}

// Принцип SRP (Принцип единственной ответственности)
// Каждый класс имеет только одну причину для изменения.

// VendingMachine.java
import java.util.*;

public class VendingMachine<T extends Product> {
    protected Map<String, T> products = new HashMap<>();

    public void addProduct(T product) {
        products.put(product.getName(), product);
    }
}

// Order.java
public class Order<T extends Product> {
    private List<T> products = new ArrayList<>();
    private double totalCost;
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void addProduct(T product) {
        if (product.getQuantity() > 0) {
            products.add(product);
            totalCost += product.getPrice() * product.getQuantity();
        }
    }

    // Принцип OCP (Принцип открытости/закрытости)
    // Класс Order закрыт для модификации и открыт для расширения.
    // Можно добавить новый функционал через наследование или композицию.

    public void sortProducts(Comparator<T> comparator) {
        products.sort(comparator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order for ").append(customerName).append(":").append("\n");
        for (T product : products) {
            sb.append(product.getName()).append(": ").append(product.getQuantity()).append("\n");
        }
        sb.append("Total cost: ").append(totalCost);
        return sb.toString();
    }
}

// Принцип SRP (Принцип единственной ответственности)
// Каждый класс имеет только одну причину для изменения.

// HotBeverage.java
public class HotBeverage extends Beverage {
    // ... код класса ...
}

// Принцип LSP (Принцип подстановки Барбары Лисков)
// Объекты в программе могут быть заменены их наследниками без изменения свойств программы.

// HotBeverageVendingMachine.java
public class HotBeverageVendingMachine extends VendingMachine<HotBeverage> {
    // ... остальной код ...
}

// Принцип SRP (Принцип единственной ответственности)
// Каждый класс имеет только одну причину для изменения.

// Main.java
public class Main {
    public static void main(String[] args) {
        VendingMachineServiceImpl<Product> vendingMachineService = new VendingMachineServiceImpl<>();

        VendingMachine<Product> vendingMachine = new VendingMachine<>();
        vendingMachineService.addProduct(vendingMachine, new Beverage("Water", 1, 20, 0, 500));
        vendingMachineService.addProduct(vendingMachine, new Food("Chips", 2, 15, 100, 0));
        
        HotBeverageVendingMachine hotBeverageVendingMachine = new HotBeverageVendingMachine();
        vendingMachineService.addProduct(hotBeverageVendingMachine, new HotBeverage("Coffee", 2, 10, 10, 250, 85));
        vendingMachineService.addProduct(hotBeverageVendingMachine, new HotBeverage("Tea", 1.5, 12, 5, 200, 80));
        
        Order<Product> order1 = new Order<>("John Doe");
        order1.addProduct(new Beverage("Water", 1, 3, 0, 500));
        order1.addProduct(new Food("Chips", 2, 2, 100, 0));
        System.out.println(order1);
        
        Order<HotBeverage> order2 = new Order<>("Jane Smith");
        order2.addProduct(new HotBeverage("Coffee", 2, 1, 10, 250, 85));
        order2.addProduct(new HotBeverage("Tea", 1.5, 2, 5, 200, 80));
        System.out.println(order2);
    }
}

```



