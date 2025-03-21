package org.dsa.examples.arrays;

// https://leetcode.com/problems/majority-element/submissions/1581490329/
// n/2 times candidate is visible
public class MajorityElement {
  public int majorityElement(int[] nums) {
    int candidate = -1;
    int count = 0;
    int n = nums.length;
    for (int i : nums) {
      if (count == 0) {
        candidate = i;
      }
      count = count + ((candidate == i) ? 1 : -1);
    }

    count = 0;

    for (int i : nums) {
      if (i == candidate) {
        count++;
      }
    }

    return count > n / 2 ? candidate : -1;
  }
}
