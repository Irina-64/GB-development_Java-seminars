// Принцип OCP (Принцип открытости/закрытости)
// Программные сущности должны быть открыты для расширения, но закрыты для модификации.
// Принцип ISP (Принцип разделения интерфейса)
// Много специализированных интерфейсов лучше, чем один универсальный.

package HW_12;

public interface VendingMachineService<T extends Product> {
    void addProduct(VendingMachine<T> vendingMachine, T product);
}


