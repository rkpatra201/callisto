package org.java.examples.threads;

public class ExtendingThread {
  public static void main(String[] args) {
    Thread th1 = new A();
    th1.start();

    Thread th2 = new Thread(new A());
    th2.start();
  }

  private static class A extends Thread{
    @Override
    public void run() {
      System.out.println(Thread.currentThread());
    }
  }
}
