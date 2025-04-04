package org.dsa.examples.v1.arrays;

import java.util.HashMap;
import java.util.Map;

public class NiceSubArraysWith_K_OddElements {

  // https://www.youtube.com/watch?v=KDH4mhFVvHw
  // https://leetcode.com/problems/subarray-sum-equals-k/

  public int solution(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    frequencyMap.put(0, 1);
    int count = 0;
    int prefixSumValue = 0;
    for (int index = 0; index < nums.length; index++) {
      //  nums[index] = nums[index] % 2 == 0 ? 0 : 1;
//      prefixSumValue = prefixSumValue + nums[index];
      prefixSumValue = prefixSumValue + (nums[index] % 2 == 0 ? 0 : 1);
      int target = prefixSumValue - k;
      count = count + frequencyMap.getOrDefault(target, 0);
      frequencyMap.put(prefixSumValue, frequencyMap.getOrDefault(prefixSumValue, 0) + 1);
    }
    return count;
  }
}
