package org.dsa.examples.v1.arrays;

public class RemoveDuplicateFromSortedArray {

  public void solution(int[] nums) {
    int uniqueIndex = 0;
    for (int index = 1; index < nums.length; index++) {
      if (nums[uniqueIndex] != nums[index]) {
        nums[++uniqueIndex] = nums[index];
      }
    }
    while (uniqueIndex < nums.length - 1) {
      nums[++uniqueIndex] = 0;
    }
  }
}
