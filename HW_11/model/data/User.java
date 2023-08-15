package Homework.Homework5.model.data;

import java.util.Calendar;

public abstract class User {

  private String name;
  private String lastName;
  private Calendar birthDay;

  public User(String name, String lastName, Calendar birthDay) {
    this.name = name;
    this.lastName = lastName;
    this.birthDay = birthDay;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Calendar getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Calendar birthDay) {
    this.birthDay = birthDay;
  }

}
