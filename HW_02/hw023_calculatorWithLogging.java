// настроить форматирование и уровень логирования можно, используя файл конфигурации logging.properties. 
// Этот файл позволяет настроить различные параметры логгирования, такие как формат вывода, уровни логирования и т.д.

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculator {
    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Введите первое число: ");
        double num1 = scanner.nextDouble();

        LOGGER.info("Введите второе число: ");
        double num2 = scanner.nextDouble();

        LOGGER.info("Выберите операцию (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                LOGGER.log(Level.SEVERE, "Ошибка: неправильная операция");
                return;
        }

        LOGGER.info("Результат: " + result);

        scanner.close();
    }
}


