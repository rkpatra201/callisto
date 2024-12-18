package org.dsa.examples.arrays;

import org.junit.Assert;
import org.junit.Test;

public class NegativeElementsToLeftTest {

  @Test
  public void solution() {
    int[] arr = {-2, 1, -3, 4, 6,};
    NegativeElementsToLeft negativeElementsToLeft = new NegativeElementsToLeft();
    negativeElementsToLeft.solution(arr);
    int[] expectedValue = {-2, -3, 1, 4, 6};
    Assert.assertArrayEquals(expectedValue, arr);
  }
}