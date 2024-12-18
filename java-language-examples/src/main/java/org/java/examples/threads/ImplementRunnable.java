package org.java.examples.threads;

public class ImplementRunnable {
  public static void main(String[] args) {
    Thread th1 = new Thread(new Worker());
    th1.start();
    Thread th2 = new Thread(new Worker());
    th2.start();
  }

  private static class Worker implements Runnable{
    @Override
    public void run() {
      System.out.println(Thread.currentThread());
    }
  }
}
