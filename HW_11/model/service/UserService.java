package Homework.Homework5.model.service;

import java.util.Calendar;
import java.util.List;

import Seminar.Seminar5.model.data.Student;
import Seminar.Seminar5.model.data.Teacher;
import Seminar.Seminar5.model.data.User;

public class UserService<T extends User> implements DateService<T> {

  @Override
  public Student createStudent(String name, String lastName, Calendar birthDay, String group, String speciality,
      double meanBall) {
    Student student = new Student(name, lastName, birthDay, group, speciality, meanBall);
    return student;
  }

  @Override
  public Teacher createTeacher(String name, String lastName, Calendar birthDay, String disciplines,
      String department, double rating) {
    Teacher teacher = new Teacher(name, lastName, birthDay, disciplines, department, rating);
    return teacher;
  }

  @Override
  public List<T> readDate() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'readDate'");
  }

}
