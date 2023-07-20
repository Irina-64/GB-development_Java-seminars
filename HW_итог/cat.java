public class Cat {
    // Поля класса
    private String name;
    private int age;
    private String color;

    // Конструктор класса
    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    // Методы класса
    public void meow() {
        System.out.println(name + " says: Meow!");
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Color: " + color);
        System.out.println();
    }

    public static void main(String[] args) {
        // Создание двух экземпляров класса Cat
        Cat cat1 = new Cat("Whiskers", 3, "gray");
        Cat cat2 = new Cat("Felix", 5, "black and white");

        // Вывод информации о котах на экран
        System.out.println("Cat 1:");
        cat1.printInfo();

        System.out.println("Cat 2:");
        cat2.printInfo();

        // Вызов метода meow() для обоих котов
        cat1.meow();
        cat2.meow();
    }
}
