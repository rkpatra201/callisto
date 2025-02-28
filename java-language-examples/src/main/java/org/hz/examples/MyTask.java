package org.hz.examples;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class MyTask implements Callable<String>, Serializable {
    @Override
    public String call() {
        Thread.dumpStack();
        return "Task executed on: " + Thread.currentThread().getName();
    }
}
