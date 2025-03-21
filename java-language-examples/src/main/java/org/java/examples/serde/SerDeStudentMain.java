package org.java.examples.serde;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


// parent class serializable makes child also serializable, so child dont need to implement serializable
// child class serializable only will give InValidClassException during readObject
public class SerDeStudentMain {
  public static void main(String[] args) throws IOException, ClassNotFoundException {

    Student p1 = new Student(1, "John", "Zee");

    FileOutputStream fos = new FileOutputStream("student.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(p1);
    oos.close();

    FileInputStream fis = new FileInputStream("student.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Student p2 = ((Student) ois.readObject());
    ois.close();

    System.out.println(p1.hashCode());
    System.out.println(p2.hashCode());

    System.out.println(p1);
    System.out.println(p2);
  }
}
