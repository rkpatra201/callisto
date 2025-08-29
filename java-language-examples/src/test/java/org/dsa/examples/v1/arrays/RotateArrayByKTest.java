package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.RotateArrayByK;
import org.junit.Test;

public class RotateArrayByKTest {

  @Test
  public void solution() {
    int[] arr = {1,2,3,4,5};
    new RotateArrayByK().solution(arr, 3);
  }
}