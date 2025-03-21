package org.dsa.examples.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// https://leetcode.com/problems/3sum/submissions/1572869039/
public class _3Sum {

  public static void main(String[] args) {
    solution();
  }

  public static void solution() {
    System.out.println(new _3Sum().threeSum(new int[]{0, 0, 0}));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);


    Set<List<Integer>> result = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum < 0) {
          left++;
        } else if (sum > 0) {
          right--;
        } else {
          result.add(List.of(nums[i], nums[left], nums[right]));
          // System.out.println("-----------"+result);
          left++;
          right--;
        }
      }
    }
    return new ArrayList(result);
  }
}
