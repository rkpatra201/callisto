package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.ReverseArray;
import org.junit.Assert;
import org.junit.Test;

public class ReverseArrayTest {

  // array has even number of elements

  @Test
  public void solution() {
    int[] arr = {1, 2, 3, 4};
    ReverseArray reverseArray = new ReverseArray();
    reverseArray.solution(arr);
    int[] expectedValue = {4, 3, 2, 1};
    Assert.assertArrayEquals(expectedValue, arr);
  }

  // array has odd number of elements
  @Test
  public void solution_1() {
    int[] arr = {1, 2, 3, 4, 5};
    ReverseArray reverseArray = new ReverseArray();
    reverseArray.solution(arr);
    int[] expectedValue = {5, 4, 3, 2, 1};
    Assert.assertArrayEquals(expectedValue, arr);
  }
}