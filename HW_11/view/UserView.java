package Homework.Homework5.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Seminar.Seminar5.controller.Controller;

public class UserView {
  Controller controller = new Controller();

  public void addUser() {
    Scanner scan = new Scanner(System.in);
    int inCommand;
    String name;
    String lastName;
    Calendar birthDay;
    String group;
    String speciality;
    double meanBall;
    String disciplines;
    String department;
    double rating;
    String[] tempDate;

    boolean noExit = true;
    while (noExit) {
      System.out.println("Выбор типа пользователя для добавления: ");
      System.out.println("1 Студент ");
      System.out.println("2 Учитель ");
      System.out.println("0 Выход");
      inCommand = scan.nextInt();
      if (inCommand == 1) {
        System.out.println("Имя: ");
        name = scan.nextLine();
        System.out.println("Фамилия: ");
        lastName = scan.next();
        System.out.println("День рождения в формате: yyyy/mm/dd: ");
        tempDate = scan.next().split("/");
        birthDay = new GregorianCalendar(Integer.parseInt(tempDate[0]), Integer.parseInt(tempDate[1]),
            Integer.parseInt(tempDate[2]));
        System.out.println("Группа: ");
        group = scan.next();
        System.out.println("Специальность: ");
        speciality = scan.next();
        System.out.println("Средний балл: ");
        meanBall = scan.nextDouble();
        System.out.println(controller.createNewStudent(name, lastName, birthDay, group, speciality, meanBall));
      } else if (inCommand == 2) {
        System.out.println("Имя: ");
        name = scan.next();
        System.out.println("Фамилия: ");
        lastName = scan.next();
        System.out.println("День рождения в формате: yyyy/mm/dd: ");
        tempDate = scan.next().split("/");
        birthDay = new GregorianCalendar(Integer.parseInt(tempDate[0]), Integer.parseInt(tempDate[1]),
            Integer.parseInt(tempDate[2]));
        System.out.println("Дисциплина: ");
        disciplines = scan.next();
        System.out.println("Кафедра: ");
        department = scan.next();
        System.out.println("Рейтинг: ");
        rating = scan.nextDouble();
        System.out.println(controller.createNewTeacher(name, lastName, birthDay, disciplines, department, rating));
      } else {
        noExit = false;
        scan.close();
        System.out.println("До свидания!");
      }
    }
  }
}
