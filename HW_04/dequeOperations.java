import java.util.Deque;
import java.util.LinkedList;

public class DequeOperations {
    public static void main(String[] args) {
        // Пример умножения двух чисел
        Deque<Integer> num1 = new LinkedList<>();
        num1.add(2);
        num1.add(4);
        num1.add(3);

        Deque<Integer> num2 = new LinkedList<>();
        num2.add(5);
        num2.add(6);
        num2.add(4);

        Deque<Integer> product = multiplyNumbers(num1, num2);
        System.out.println("Произведение чисел: " + product);

        // Пример сложения двух чисел
        Deque<Integer> num3 = new LinkedList<>();
        num3.add(-7);
        num3.add(8);
        num3.add(9);

        Deque<Integer> num4 = new LinkedList<>();
        num4.add(1);
        num4.add(2);
        num4.add(3);

        Deque<Integer> sum = addNumbers(num3, num4);
        System.out.println("Сумма чисел: " + sum);
    }

    public static Deque<Integer> multiplyNumbers(Deque<Integer> num1, Deque<Integer> num2) {
        Deque<Integer> product = new LinkedList<>();
        int carry = 0;

        for (int digit1 : num1) {
            int tempCarry = 0;
            Deque<Integer> tempProduct = new LinkedList<>();

            for (int digit2 : num2) {
                int multiply = (digit1 * digit2) + tempCarry;
                tempProduct.add(multiply % 10);
                tempCarry = multiply / 10;
            }

            if (tempCarry > 0) {
                tempProduct.add(tempCarry);
            }

            addZeros(tempProduct, carry);
            addNumbers(product, tempProduct);
            carry++;
        }

        return product;
    }

    public static Deque<Integer> addNumbers(Deque<Integer> num1, Deque<Integer> num2) {
        Deque<Integer> sum = new LinkedList<>();
        int carry = 0;

        while (!num1.isEmpty() || !num2.isEmpty()) {
            int digit1 = num1.isEmpty() ? 0 : num1.remove();
            int digit2 = num2.isEmpty() ? 0 : num2.remove();
            int tempSum = digit1 + digit2 + carry;

            sum.add(tempSum % 10);
            carry = tempSum / 10;
        }

        if (carry > 0) {
            sum.add(carry);
        }

        return sum;
    }

    public static void addZeros(Deque<Integer> num, int zeros) {
        for (int i = 0; i < zeros; i++) {
            num.addFirst(0);
        }
    }
}
