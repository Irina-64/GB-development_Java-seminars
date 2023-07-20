import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "John", "123456789");
        addContact(phoneBook, "Jane", "987654321");
        addContact(phoneBook, "John", "456789123");
        addContact(phoneBook, "Mike", "555555555");
        addContact(phoneBook, "Jane", "111111111");
        addContact(phoneBook, "Mike", "666666666");

        // Вывод телефонной книги отсортированной по убыванию числа телефонов
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.putIfAbsent(name, new HashSet<>());
        phoneBook.get(name).add(phoneNumber);
    }

    // Метод для вывода телефонной книги отсортированной по убыванию числа телефонов
    public static void printPhoneBook(Map<String, Set<String>> phoneBook) {
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Сортировка по убыванию числа телефонов
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        int contactNumber = 1;
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();
            System.out.println(contactNumber + ". " + name + ": " + phoneNumbers);
            contactNumber++;
        }
    }
}
