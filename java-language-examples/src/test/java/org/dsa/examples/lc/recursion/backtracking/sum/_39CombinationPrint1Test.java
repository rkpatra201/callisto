package org.dsa.examples.lc.recursion.backtracking.sum;

import org.junit.Test;

import static org.junit.Assert.*;

public class _39CombinationPrint1Test {

  @Test
  public void combinationSum() {
    int[] nums = {2, 3, 6, 7};
    int target = 7;
    Object result = new _39CombinationPrint1().combinationSum(nums, target);
    System.out.println(result);
  }
}