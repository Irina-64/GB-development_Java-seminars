package HW_10;

public interface VendingMachineService<T extends Product> {
    void addProduct(VendingMachine<T> vendingMachine, T product);
}


