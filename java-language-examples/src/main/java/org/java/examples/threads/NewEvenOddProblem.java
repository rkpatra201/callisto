package org.java.examples.threads;

/**
 * display
 * increment
 * notify
 * wait
 *
 * and at the end when value crossed limit then do
 * notify
 */
public class NewEvenOddProblem {

  private static final int limit = 10;

  public static void main(String[] args) {
    ValueWrapper v = new ValueWrapper(0);
    Printer evenPrinter = new Printer(v, "EVEN");
    Printer oddPrinter = new Printer(v, "ODD");
    new Thread(evenPrinter).start();
    new Thread(oddPrinter).start();
  }

  private static class ValueWrapper {
    int value;

    public ValueWrapper(int value) {
      this.value = value;
    }
  }

  private static class Printer implements Runnable {
    private final ValueWrapper valueWrapper;
    private String workerName;

    public Printer(ValueWrapper valueWrapper, String workerName) {
      this.valueWrapper = valueWrapper;
      this.workerName = workerName;
    }

    @Override
    public void run() {
      synchronized (valueWrapper) {
        while (valueWrapper.value <= 10) {
          System.out.println(this.workerName + ":" + valueWrapper.value);
          valueWrapper.value = valueWrapper.value + 1;
          valueWrapper.notify();
          try {
            valueWrapper.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
        valueWrapper.notify();
      }
    }
  }


  private static class OddWorker implements Runnable {
    private int value;
    private String worker;
    private String lock;

    public OddWorker(int value, String lock) {
      this.value = value;
      this.worker = "ODD";
      this.lock = lock;
    }

    @Override
    public void run() {
      synchronized (lock.intern()) {
        while (value <= 10) {
          System.out.println(this.worker + ":" + value);
          value = value + 2;
          lock.notify();

          try {
            lock.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
        if (value >= 10) {
          lock.notify();
        }
      }
    }
  }
}
