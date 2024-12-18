package org.dsa.examples.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SubArraySumTest {

  @Test
  public void solution() {
    int[] arr = {1, 3, 4, 2, 5, 6, 7};
    SubArraySum subArraySum = new SubArraySum();
    int[] expectedValue = {4, 2, 5};
    int[] indexes = subArraySum.solution(arr, 11);
    int[] actualValue = Arrays.copyOfRange(arr, indexes[0], indexes[1]);
    Assert.assertArrayEquals(expectedValue, actualValue);
  }

  @Test
  public void solution_1() {
    int[] arr = {1, 3, 4, 2, 5, 6, 7};
    SubArraySum subArraySum = new SubArraySum();
    int[] expectedValue = {1, 3, 4, 2};
    int[] indexes = subArraySum.solution(arr, 10);
    int[] actualValue = Arrays.copyOfRange(arr, indexes[0], indexes[1]);
    Assert.assertArrayEquals(expectedValue, actualValue);
  }
}