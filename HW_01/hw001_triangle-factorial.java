import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение для n: ");
        int n = scanner.nextInt();

        // Вычисление треугольного числа
        int triangularNumber = calculateTriangularNumber(n);
        System.out.println("Треугольное число для " + n + ": " + triangularNumber);

        // Вычисление факториала
        int factorial = calculateFactorial(n);
        System.out.println("Факториал " + n + ": " + factorial);

        scanner.close();
    }

    // Метод для вычисления треугольного числа
    public static int calculateTriangularNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // Метод для вычисления факториала
    public static int calculateFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

