package org.java.examples.threads;

import java.util.stream.IntStream;

public class ThreadStates {

  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(th1, "T1");
    Thread thread2 = new Thread(th2, "T2");
    printStates(thread1, thread2);
    thread1.start();
    Thread.sleep(1000);
    printStates(thread1, thread2);
    thread2.start();

    int count = 0;
    while(true){
      if(count == 20){
        break;
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      count = count+1;
      printStates(thread1, thread2);
    }
  }

  private static void printStates(Thread th1, Thread th2){
    System.out.println(th1.getState()+":"+th2.getState());
  }

  private static Object object = new Object();
  private static Runnable th1 = ()->{
    System.out.println("THREAD1 EXECUTING");
    synchronized (object){
      System.out.println("T1 got lock");
      try {
        Thread.sleep(4000);
        object.wait(4000);
        System.out.println("T1 lost the lock");
        search(IntStream.rangeClosed(0, 10000).toArray(), 32000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  };


  private static Runnable th2 = ()->{
    long t1 = System.currentTimeMillis();
    System.out.println("THREAD2 EXECUTING");
    synchronized (object){
      System.out.println("T2 got lock: "+ (System.currentTimeMillis() - t1));
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  };

  private static int search(int[] arr, int x){
    for(int i = 0; i < arr.length;){
      if(x == arr[i]){
        return x;
      }
    }
    System.out.println("RETURN HAPPENING");
    return -1;
  }
}
