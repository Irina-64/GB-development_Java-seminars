package HW_12;

import java.util.HashMap;
import java.util.Map;

import HW_12.alliance.*;
import HW_12.*;

// Принцип LSP (Принцип подстановки Барбары Лисков)
// Объекты в программе могут быть заменены их наследниками без изменения свойств программы.

public class Beverage extends Product {
    public Beverage(String name, double price, double quantity, double weight, double volume) {
        super(name, price, quantity, weight, volume);
    }
}
