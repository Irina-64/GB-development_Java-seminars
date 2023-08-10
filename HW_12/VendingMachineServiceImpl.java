package HW_12;

import HW_12.alliance.*;
import HW_12.*;

// Принцип DIP (Принцип инверсии зависимостей)
// Зависимости должны строиться относительно абстракций, а не деталей.

public class VendingMachineServiceImpl<T extends Product> implements VendingMachineService<T> {
    @Override
    public void addProduct(VendingMachine<T> vendingMachine, T product) {
        vendingMachine.addProduct(product);
    }
}
