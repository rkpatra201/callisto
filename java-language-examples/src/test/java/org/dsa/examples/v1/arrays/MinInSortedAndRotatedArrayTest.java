package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.MinInSortedAndRotatedArray;
import org.junit.Assert;
import org.junit.Test;


public class MinInSortedAndRotatedArrayTest {

  @Test
  public void solution() {
    int[] nums = {3, 4, 5, 1, 2};
    MinInSortedAndRotatedArray min = new MinInSortedAndRotatedArray();
    int minValue = min.solution(nums);
    Assert.assertSame(1, minValue);
  }
}