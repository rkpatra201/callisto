package org.dsa.examples.v1.recursion;

import org.dsa.examples.v1.recursion.KCombination;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

// https://umakantv.com/blog/combination-sum-ii
public class KCombinationTest {

  @Test
  public void solution() throws MalformedURLException, InterruptedException, ClassNotFoundException {
    new KCombination().solution(new int[]{1, 2, 3, 4}, 2);

    String path = "file:/C:\\Users\\RabindraPatra\\workspace\\code\\dmp-kafka-security\\sample-jar-app\\src\\main\\java\\app.jar";
    String className = "org.dsa.examples.App1";

    Runnable worker1 = new Worker("", className);
    AppClassLoader classLoader = new AppClassLoader(new URL[]{new URL(path)});
    Thread th1 = new Thread(worker1);
    th1.setContextClassLoader(classLoader);
    th1.start();
    Thread.sleep(3000);

    Class.forName(className);
  }

  private static class Worker implements Runnable {
    private String className;
    private String jarPath;

    public Worker(String path, String className) {
      this.jarPath = path;
      this.className = className;
    }

    @Override
    public void run() {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      try {
        Class clazz = loader.loadClass(className);
        System.out.println(clazz);
        Thread.sleep(30000);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  private static class AppClassLoader extends URLClassLoader {

    public AppClassLoader(URL[] urls) {
      super(urls);
    }
  }
}