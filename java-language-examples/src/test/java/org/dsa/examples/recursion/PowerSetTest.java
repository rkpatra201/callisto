package org.dsa.examples.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerSetTest {

  @Test
  public void solution() {
    int[] arr = {1, 2, 3};
    new PowerSet().solution(arr);
  }
}