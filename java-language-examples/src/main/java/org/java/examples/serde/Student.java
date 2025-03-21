package org.java.examples.serde;

import java.io.Serializable;

public class Student extends Person {

  private String school;

  public Student(int id, String name, String school) {
    super(id, name);
    this.school = school;
  }

  @Override
  public String toString() {
    return super.toString() + "Student{" +
        "school='" + school + '\'' +
        '}';
  }
}
