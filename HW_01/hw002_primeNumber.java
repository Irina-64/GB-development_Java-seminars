// При выполнении этого кода на экране будут выведены все простые числа от 1 до 1000.

public class Main {
    public static void main(String[] args) {
        System.out.println("Простые числа от 1 до 1000:");
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Метод для проверки, является ли число простым
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
