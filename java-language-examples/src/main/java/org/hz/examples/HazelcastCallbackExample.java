package org.hz.examples;

import com.hazelcast.cluster.Member;
import com.hazelcast.config.Config;
import com.hazelcast.core.*;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class HazelcastCallbackExample {
    public static void main(String[] args) {
        // Start Hazelcast cluster with two instances
        HazelcastInstance instance1 = Hazelcast.newHazelcastInstance(new Config());
        HazelcastInstance instance2 = Hazelcast.newHazelcastInstance(new Config());

        // Get the cluster and pick a member
        Member targetMember = instance1.getCluster().getMembers().iterator().next();

        // Get ExecutorService
        IExecutorService executorService = instance1.getExecutorService("test");

        // Submit task to the selected member with a callback
        executorService.submitToMember(new MyTask(), targetMember, new ExecutionCallback<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Task completed! Result: " + response);
            }

            @Override
            public void onFailure(Throwable t) {
                System.err.println("Task failed: " + t.getMessage());
            }
        });

        System.out.println("Task submitted asynchronously...");
    }

    // Task that will run on a member
    static class MyTask implements Callable<String>, Serializable {
        @Override
        public String call() {
            Thread.dumpStack();
            return "Executed on: " + Thread.currentThread().getName();
        }
    }
}
