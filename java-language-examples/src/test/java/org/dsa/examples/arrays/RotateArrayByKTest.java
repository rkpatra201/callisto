package org.dsa.examples.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateArrayByKTest {

  @Test
  public void solution() {
    int[] arr = {1,2,3,4,5};
    new RotateArrayByK().solution(arr, 3);
  }
}