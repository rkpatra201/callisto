package org.java.examples.threads;

public class SynchronizeInstanceMethods {

  private static Employee employeeVar = new Employee();
  public static void main(String[] args) {
    new Thread(th2).start();
    new Thread(th1).start();
    new Thread(th3).start();
  }

  private static Runnable th1 = () -> {
    employeeVar.m1();
  };

  private static Runnable th2 = ()->{
    employeeVar.m2();
  };

  private static Runnable th3 = ()->{
    System.out.println(Thread.currentThread());
    new Employee().m1();
  };

  private static class Employee{
    private synchronized void m1(){
      System.out.println("INSIDE M1");
    }

    private synchronized void m2(){
      System.out.println("INSIDE M2");
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
