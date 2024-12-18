package org.java.examples.threads;

public class SynchronizeStaticMethods {
  public static void main(String[] args) {
    new Thread(th2).start();
    new Thread(th1).start();
  }

  private static Runnable th1 = () -> {
    Employee.m1();
  };

  private static Runnable th2 = ()->{
    Employee.m2();
  };
  private static class Employee{
    private static synchronized void m1(){
      System.out.println("INSIDE M1");
    }

    private static synchronized void m2(){
      System.out.println("INSIDE M2");
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
