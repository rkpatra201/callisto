package org.java.examples.threads;

public class SharingObject {
  public static void main(String[] args) {
    Employee e = new Employee();
    Thread th1 = new Thread(new Worker(e));
    Thread th2 = new Thread(new Worker(e));
    th1.start();
    th2.start();
  }

  private static class Employee{

  }

  private static class Worker implements Runnable{
    private Employee employee;

    public Worker(Employee employee) {
      this.employee = employee;
    }

    @Override
    public void run() {
      synchronized (employee) {
        System.out.println(Thread.currentThread() + ":" + employee.hashCode());
        try {
//          employee.wait();
        } catch (RuntimeException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
