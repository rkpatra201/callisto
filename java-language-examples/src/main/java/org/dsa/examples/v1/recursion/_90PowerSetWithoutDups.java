package org.dsa.examples.v1.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/submissions/1593822024/
public class _90PowerSetWithoutDups {
  public List<List<Integer>> subsetsWithDup(int[] nums) {

    Arrays.sort(nums);
    backtrack(0, nums, new ArrayList<>());

    return all;
  }

  List<List<Integer>> all = new ArrayList<>();

  private void backtrack(int start, int[] nums, List<Integer> results) {

    all.add(new ArrayList<>(results));

    for (int i = start; i < nums.length; i++) {

      if (i > start && nums[i - 1] == nums[i]) {
        continue;
      }

      results.add(nums[i]);
      backtrack(i + 1, nums, results);
      results.remove(results.size() - 1);
    }
  }
}
