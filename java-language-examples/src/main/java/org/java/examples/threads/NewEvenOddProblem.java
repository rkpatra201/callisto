package org.java.examples.threads;

/**
 * chnage state and then notify + wait
 */
public class NewEvenOddProblem {

  private static final int limit = 10;

  public static void main(String[] args) {
    String lock = "lock";
    ValueWrapper v = new ValueWrapper(0);
    EvenWorker evenWorker = new EvenWorker(v, "EVEN");
    EvenWorker oddWorker = new EvenWorker(v, "ODD");
    new Thread(evenWorker).start();
    new Thread(oddWorker).start();
  }

  private static class ValueWrapper {
    int value;

    public ValueWrapper(int value) {
      this.value = value;
    }
  }

  private static class EvenWorker implements Runnable {
    private final ValueWrapper valueWrapper;
    private String worker;
    private String lock;

    public EvenWorker(ValueWrapper valueWrapper, String lock) {
      this.valueWrapper = valueWrapper;
      this.worker = lock;
      this.lock = lock;
    }

    @Override
    public void run() {
      synchronized (valueWrapper) {
        while (valueWrapper.value <= 10) {
          System.out.println(this.lock + ":" + valueWrapper.value);
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
