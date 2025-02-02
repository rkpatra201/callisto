package org.java.examples.threads;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor
                = new ThreadPoolExecutor(
                2,
                5,
                10, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(30), // on queue full tasks will be rejected and pool will scale up to maximumPoolSize
                new CustomThreadFactory()
        );

        int i = 0;

       while(true){
           if(i == 100){
               System.out.println("breaking");
               break;
           }
           executor.execute(()->{
               System.out.println(Thread.currentThread()+":"+executor.getQueue().size());
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           });
           i++;

       }

    }

    private static class CustomThreadFactory implements ThreadFactory{
        private static int count = 0;
        private static String THREAD_PREFIX="custom-pool-thread";
        @Override
        public Thread newThread(@NotNull Runnable r) {
            ThreadGroup threadGroup = new ThreadGroup("custom-thread-group");
            threadGroup.setMaxPriority(10);
            Thread th = new Thread(threadGroup, r);
            th.setName(THREAD_PREFIX+"-"+getCount());
            return th;
        }

        public static int getCount() {
            return ++count;
        }
    }
}
