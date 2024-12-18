package org.java.examples.threads;

public class PrinterProblem {

  public static void main(String[] args) {
    boolean[] arr = {false};
    new Thread(new Even(arr, 0)).start();
    new Thread(new Odd(arr, -1)).start();
  }

  private static class Even implements Runnable {

    private boolean[] arr;
    private int count;

    public Even(boolean[] arr, int count) {
      this.arr = arr;
      this.count = count;
    }

    @Override
    public void run() {
      while (true) {
        synchronized (arr) {
          if (arr[0]) {
            count = count + 2;
            if (count > 10) {
              arr[0] = false;
              arr.notify();
              break;
            }
            System.out.println(getClass().getSimpleName() + ":" + count);
            arr[0] = false;
            arr.notify();
          } else {
            PrinterProblem.wait(arr);
          }
        }
      }
    }
  }


  private static class Odd implements Runnable {

    private boolean[] arr;
    private int count;

    public Odd(boolean[] arr, int count) {
      this.arr = arr;
      this.count = count;
    }

    @Override
    public void run() {
      while (true) {
        synchronized (arr) {
          if (!arr[0]) {
            count = count + 2;
            if (count > 10){
              arr[0] = true;
              arr.notify();
              break;
            };
            System.out.println(getClass().getSimpleName() + ":" + count);
            arr[0] = true;
            arr.notify();
          } else {
            PrinterProblem.wait(arr);
          }
        }
      }
    }
  }

  private static void wait(boolean[] arr) {
    try {
      arr.wait();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
