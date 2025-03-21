package org.java.examples.serde;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDePersonMain {
  public static void main(String[] args) throws IOException, ClassNotFoundException {

    Person p1 = new Person(1, "John");
    FileOutputStream fos = new FileOutputStream("person.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(p1);

    FileInputStream fis = new FileInputStream("person.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Person p2 = ((Person) ois.readObject());

    System.out.println(p1.hashCode());
    System.out.println(p2.hashCode());

    System.out.println(p1);
    System.out.println(p2);
  }
}
