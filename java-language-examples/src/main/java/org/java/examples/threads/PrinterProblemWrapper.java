package org.java.examples.threads;

public class PrinterProblemWrapper {

  public static void main(String[] args) {
    Counter counter = new Counter(1, 13);
    new Thread(new Printer(counter, "even")).start();
    new Thread(new Printer(counter, "odd")).start();
  }

  private static class Counter {
    int value;
    int limit;

    public Counter(int value, int limit) {
      this.value = value;
      this.limit = limit;
    }

    public boolean isEven() {
      return value % 2 == 0;
    }

    public boolean hasLimit() {
      return value < limit;
    }

    public void increment() {
      this.value++;
    }
  }

  private static class Printer implements Runnable {

    private final Counter counter;
    private String name;

    public Printer(Counter counter, String name) {
      this.counter = counter;
      this.name = name;
    }

    private boolean incrementAllowed() {
      if (this.name.equalsIgnoreCase("even") && !counter.isEven()) {
        return true;
      }
      if (this.name.equalsIgnoreCase("odd") && counter.isEven()) {
        return true;
      }
      return false;
    }

    @Override
    public void run() {
      while (true) {
        synchronized (counter) {

          if (!counter.hasLimit()) {
            counter.notify();
            break;
          }

          if (!incrementAllowed()) {
            PrinterProblemWrapper.wait(counter);
            continue;
          }

          counter.increment();
          System.out.println(name + ":" + counter.value);
          counter.notify();
        }
      }
      System.out.println(this.name + ": completed");
    }
  }

  private static void wait(Counter counter) {
    try {
      counter.wait();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
