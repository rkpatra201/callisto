package org.dsa.examples.v1.dp.str.lis;

import java.util.ArrayList;
import java.util.List;

/**
 * I watched it on:
 * 10th March 2025
 * https://www.youtube.com/watch?v=ekKYRYFEm9w&t=871s
 */
public class _6LongestIncreaseSubSequence {

  public List<Integer> solution(int[] nums) {
    return solution(nums, 0, -1);
  }

  /**
   *  40,80,41,42
   *
   *  why exclude: 80 because if we exclude then only we can form a larger
   *  subseuqnce here. The values are 41,42 smaller than 80
   * @param nums
   * @param index
   * @param prevIndex
   * @return
   */
  private List<Integer> solution(int[] nums, int index, int prevIndex) {
    if (index == nums.length) { // dead end
      return new ArrayList<>();
    }

    List<Integer> excluded = solution(nums, index + 1, prevIndex);
    List<Integer> included = new ArrayList<>();

    int current = nums[index];
    int prev = prevIndex == -1 ? Integer.MIN_VALUE : nums[prevIndex];

    if(current > prev){
      included = solution(nums, index + 1, index);
      included.add(0, current);
    }
    System.out.println(included);
    System.out.println(excluded);
    return included.size() > excluded.size() ? included : excluded;
  }
}
