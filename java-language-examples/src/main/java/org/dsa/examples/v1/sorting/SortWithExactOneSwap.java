package org.dsa.examples.v1.sorting;

public class SortWithExactOneSwap {
  public void solution(int[] nums) {
    int j = -1, k = -1;

    // Find first misplaced element
    for (int i = 1; i < nums.length; i++) {
      if (j == -1 && nums[i] < nums[i - 1]) {
        j = i - 1; // First out-of-order index
      }

      if (j != -1 && nums[i] < nums[i - 1]) {
        k = i; // Last out-of-order index
      }
    }

    // Ensure valid swap indices
    if (j == -1 || k == -1) {
      return;
    }

    // Swap the misplaced elements
    int temp = nums[j];
    nums[j] = nums[k];
    nums[k] = temp;
  }
}
