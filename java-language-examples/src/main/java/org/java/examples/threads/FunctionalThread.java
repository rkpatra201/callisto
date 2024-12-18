package org.java.examples.threads;

public class FunctionalThread {
  public static void main(String[] args) {
    Thread th1 = new Thread(worker1);
    Thread th2 = new Thread(worker1);
    th1.start();
    th2.start();
  }

  private static Runnable worker1 = ()->{
    System.out.println(Thread.currentThread());
  };
}
