package org.java.examples.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProducerConsumerProblem {

  public static void main(String[] args) throws InterruptedException {
    List<String> list = new ArrayList<>();
    new Thread(new Consumer(list, 50)).start();
    Thread.sleep(200);
    new Thread(new Producer(list, 50)).start();
  }

  private static class Producer implements Runnable {
    private List<String> list;
    private int maxMessage;

    public Producer(List<String> list, int maxMessage) {
      this.list = list;
      this.maxMessage = maxMessage;
    }

    @Override
    public void run() {
      while (true) {
        if (maxMessage == 0) {
          break;
        }
        synchronized (list) {
          try {
            if (list.size() == maxMessage) {
              list.wait();
            }
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          list.add(UUID.randomUUID().toString() + ":" + maxMessage);
          maxMessage--;
          System.out.println("produced");
          list.notify();
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
  }


  private static class Consumer implements Runnable {
    private List<String> list;
    private int maxMessage;

    public Consumer(List<String> list, int maxMessage) {
      this.list = list;
      this.maxMessage = maxMessage;
    }

    @Override
    public void run() {
      while (true) {
        synchronized (list) {
          if (list.size() == 0) {
            try {
              list.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
          String result = list.remove(0);
          System.out.println(result);
          list.notify();
        }
      }
    }
  }
}
