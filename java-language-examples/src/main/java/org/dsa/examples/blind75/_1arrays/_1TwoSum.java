package org.dsa.examples.blind75._1arrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/submissions/1581451352/
public class _1TwoSum {
  public int[] twoSum(int[] nums, int target) {
    return solution(nums, target);
  }

  public int[] solution(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        return new int[] { i, map.get(diff) };
      }
      map.put(nums[i], i);
    }

    return new int[] {};
  }

}
