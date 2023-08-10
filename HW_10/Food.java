package HW_10;

// Класс Food (Еда) с полем weight (масса) и методом toString()
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