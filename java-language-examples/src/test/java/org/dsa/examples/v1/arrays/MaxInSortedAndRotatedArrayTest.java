package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.MaxInSortedAndRotatedArray;
import org.junit.Assert;
import org.junit.Test;


public class MaxInSortedAndRotatedArrayTest {

  @Test
  public void solution() {
    int[] nums = {3, 4, 5, 1, 2};
    MaxInSortedAndRotatedArray min = new MaxInSortedAndRotatedArray();
    int maxValue = min.solution(nums);
    Assert.assertSame(5, maxValue);
  }
}