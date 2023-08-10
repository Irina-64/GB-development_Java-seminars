package HW_10;

import java.util.*;

import HW_10.alliance.*;
import HW_10.*;

public class Program {
    public static void main(String[] args) {
        VendingMachineServiceImpl<Product> vendingMachineService = new VendingMachineServiceImpl<>();

        VendingMachine<Product> vendingMachine = new VendingMachine<>();
        vendingMachineService.addProduct(vendingMachine, new Beverage("Water", 1, 20, 0, 500));
        vendingMachineService.addProduct(vendingMachine, new HotBeverage("Tea", 1.5, 10, 5, 200, 80));

        HotBeverageVendingMachine hotBeverageVendingMachine = new HotBeverageVendingMachine();
        vendingMachineService.addProduct(hotBeverageVendingMachine, new HotBeverage("Coffee", 2, 15, 10, 250, 90));
        vendingMachineService.addProduct(hotBeverageVendingMachine, new HotBeverage("Hot Chocolate", 2.5, 8, 8, 300, 85));

        Order<Product> order1 = new Order<>("John Doe");
        order1.addProduct(new Beverage("Water", 1, 3, 0, 500));
        order1.addProduct(new Beverage("Juice", 2, 2, 0, 300));
        System.out.println(order1);

        Order<HotBeverage> order2 = new Order<>("Jane Smith");
        order2.addProduct(new HotBeverage("Tea", 1.5, 2, 5, 200, 80));
        order2.addProduct(new HotBeverage("Coffee", 2, 1, 10, 250, 90));
        System.out.println(order2);
    }
}

interface VendingMachineService<T extends Product> {
    void addProduct(VendingMachine<T> vendingMachine, T product);
}

class VendingMachine<T extends Product> {
    protected Map<String, T> products = new HashMap<>();

    public void addProduct(T product) {
        products.put(product.getName(), product);
    }
}

class HotBeverageVendingMachine extends VendingMachine<HotBeverage> {
    // ... остальной код ...
}

class Order<T extends Product> {
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

class VendingMachineServiceImpl<T extends Product> implements VendingMachineService<T> {
    @Override
    public void addProduct(VendingMachine<T> vendingMachine, T product) {
        vendingMachine.addProduct(product);
    }
}

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
