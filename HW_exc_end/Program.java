import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataEntryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол):");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split(" ");
            
            // Проверяем, что введено правильное количество данных
            if (parts.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных. Ожидалось 6 полей.");
            }

            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];
            String dateOfBirth = parts[3];
            String phoneNumber = parts[4];
            String gender = parts[5];

            // Проверяем форматы данных
            if (!isValidDateOfBirth(dateOfBirth)) {
                throw new IllegalArgumentException("Неверный формат даты рождения. Ожидается dd.mm.yyyy.");
            }
            
            if (!isValidPhoneNumber(phoneNumber)) {
                throw new IllegalArgumentException("Неверный формат номера телефона. Ожидается целое беззнаковое число.");
            }
            
            if (!isValidGender(gender)) {
                throw new IllegalArgumentException("Неверное значение пола. Ожидается 'f' или 'm'.");
            }

            // Создаем или открываем файл с фамилией для записи
            BufferedWriter writer = new BufferedWriter(new FileWriter(lastName + ".txt", true));

            // Записываем данные в файл
            writer.write(lastName + firstName + middleName + dateOfBirth + " " + phoneNumber + gender + "\n");

            // Закрываем файл
            writer.close();

            System.out.println("Данные успешно записаны.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidDateOfBirth(String dateOfBirth) {
        // Пример простой проверки формата даты рождения
        return dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Пример простой проверки формата номера телефона
        return phoneNumber.matches("\\d+");
    }

    private static boolean isValidGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }
}
