package HW_010;

import HW_010.alliance.*;
import HW_010.*;

public class VendingMachineServiceImpl<T extends Product> implements VendingMachineService<T> {
    @Override
    public void addProduct(VendingMachine<T> vendingMachine, T product) {
        vendingMachine.addProduct(product);
    }
}
