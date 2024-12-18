package org.dsa.examples.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class WildCardMatchingTest {

  @Test
  public void solution() {
    String pattern = "ab?d?e*f";
    String str = "abdddeklmf";
    boolean result = new WildCardMatching().solution(str, pattern);
    System.out.println(result);
  }
}