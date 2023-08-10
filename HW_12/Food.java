package HW_12;

// Класс Food (Еда) с полем weight (масса) и методом toString()
// Принцип LSP (Принцип подстановки Барбары Лисков)
// Объекты в программе могут быть заменены их наследниками без изменения свойств программы.

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