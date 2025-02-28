package org.hz.examples;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HazelcastExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Start a Hazelcast instance
        Config config = new Config();
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        // Get the distributed executor service
        IExecutorService executorService = hazelcastInstance.getExecutorService("test");

        // Class Name                                                    | Shallow Heap | Retained Heap
        //---------------------------------------------------------------------------------------------
        //com.hazelcast.executor.impl.ExecutorServiceProxy @ 0x503754648|           40 |           112
        //---------------------------------------------------------------------------------------------
        // Submit task
        Future<String> future = executorService.submit(new MyTask());

        // Get the result
        String result = future.get();
        System.out.println("Result: " + result);

        // Shutdown Hazelcast
        hazelcastInstance.shutdown();
    }
}
