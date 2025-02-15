package org.dsa.examples.arrays;

import org.junit.Test;


public class SubArraySumEqualsKTest {

  @Test
  public void solution() {
    int[] nums = {2, 5, 8, 1, 5, 8};
    int k = 13;
    SubArraySumEqualsK t = new SubArraySumEqualsK();
    int result = t.solution(nums, k);
    System.out.println(result);
  }
}