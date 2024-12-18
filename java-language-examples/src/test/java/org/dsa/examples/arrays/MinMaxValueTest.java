package org.dsa.examples.arrays;

import org.junit.Assert;
import org.junit.Test;

public class MinMaxValueTest {

  @Test
  public void solution() {
    int[] arr = {2, 10, 3, 4, 7, 9,};
    MinMaxValue minMaxValue = new MinMaxValue();
    int[] actualValue = minMaxValue.solution(arr);
    int[] expectedValue = {2, 10};
    Assert.assertArrayEquals(expectedValue,actualValue);
  }
}