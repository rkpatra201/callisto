package org.dsa.examples.v1.recursion;

import org.dsa.examples.v1.recursion.PowerSet;
import org.junit.Test;

public class PowerSetTest {

  @Test
  public void solution() {
    int[] arr = {1, 2, 3};
    new PowerSet().solution(arr);
  }
}