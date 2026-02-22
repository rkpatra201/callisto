package org.dsa.examples.blind75._2binary;

// https://leetcode.com/problems/missing-number/submissions/1589484260/
public class _268MissingNum {
  public int missingNumber(int[] nums) {
    int xorall = 0;
    for (int i = 0; i < nums.length + 1; i++) {
      xorall ^= i;
    }

    int xornum = 0;
    for (int i : nums) {
      xornum ^= i;
    }

    return xorall ^ xornum;
  }
}
