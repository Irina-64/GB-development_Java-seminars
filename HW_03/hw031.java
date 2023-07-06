import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOperations {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int count = scanner.nextInt();

        System.out.println("Введите числа:");
        for (int i = 0; i < count; i++) {
            int number = scanner.nextInt();
            numbers.add(number);
        }
        scanner.close();

        // Удаление четных чисел
        List<Integer> oddNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }

        // Нахождение минимального значения
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        // Нахождение максимального значения
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        // Нахождение среднего значения
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double average = sum / numbers.size();

        System.out.println("Список после удаления четных чисел: " + oddNumbers);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }
}

