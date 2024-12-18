package org.java.examples.threads;

public class ThreadJoin {
  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(th1);
    Thread thread2 = new Thread(th2);

    thread1.start();
    thread1.join();

    thread2.start();
    thread2.join();
    System.out.println("DONE");
  }

  private static Runnable th1 = () -> {
    System.out.println("Hello");
  };


  private static Runnable th2 = () -> {
    System.out.println("Hi");
  };
}
