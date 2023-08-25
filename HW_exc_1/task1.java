package HW_exc_1;

import java.util.*;

class Answer {
    public static void arrayOutOfBoundsException() {
        int[] arr = new int[5];
        int value = arr[10];
      
}

    public static void divisionByZero() {
        int a = 1;
        int b = 0;
        int c = a / b;
}

    public static void numberFormatException() {
        String str = "abc";
        int value = Integer.parseInt(str); 
       
 }
}

public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}
