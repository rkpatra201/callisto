package org.dsa.examples.v1.recursion;

import org.dsa.examples.v1.recursion.WildCardMatching;
import org.junit.Test;

public class WildCardMatchingTest {

  @Test
  public void solution() {
    String pattern = "ab?d?e*f";
    String str = "abdddeklmf";
    boolean result = new WildCardMatching().solution(str, pattern);
    System.out.println(result);
  }
}