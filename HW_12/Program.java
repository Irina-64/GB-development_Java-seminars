package HW_12;

import java.util.*;

import HW_12.alliance.*;
import HW_12.*;

// Принцип SRP (Принцип единственной ответственности)
// Каждый класс имеет только одну причину для изменения.

public class Program {
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

