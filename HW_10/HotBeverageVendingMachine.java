package HW_10;

public class HotBeverageVendingMachine extends VendingMachine<HotBeverage> {
// Метод проверки наличия продуктов в автомате перед оформлением заказа
    public void validateOrder(Order order) {
        List<Product> productsToRemove = new ArrayList<>();

        for (Product product : order.getProducts()) {
            Product availableProduct = products.get(product.getName());
            if (availableProduct == null || availableProduct.getQuantity() < product.getQuantity()) {
                productsToRemove.add(product);
            }
        }

        order.getProducts().removeAll(productsToRemove);
    }
}

