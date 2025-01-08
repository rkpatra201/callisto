package org.dsa.examples.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinInSortedAndRotatedArrayTest {

  @Test
  public void solution() {
    int[] nums = {3, 4, 5, 1, 2};
    MinInSortedAndRotatedArray min = new MinInSortedAndRotatedArray();
    int minValue = min.solution(nums);
    Assert.assertSame(1, minValue);
  }
}