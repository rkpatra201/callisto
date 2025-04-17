package org.dsa.examples.v1.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/submissions/1593822024/
public class PowerSetWithoutDups {
  public List<List<Integer>> subsetsWithDup(int[] nums) {

    Arrays.sort(nums);
    backtrack(0, nums, new ArrayList<>());

    return all;
  }

  List<List<Integer>> all = new ArrayList<>();
  private void backtrack(int pos, int[] nums, List<Integer> results) {
    if (pos > nums.length - 1) {
      System.out.println(results);
      all.add(new ArrayList<>(results)); // Defensive copy
      return;
    }

    // Skip duplicates BEFORE anything
    int nextPos = pos;
    while (nextPos < nums.length - 1 && nums[nextPos + 1] == nums[nextPos]) {
      nextPos++;
    }

    // Take current element
    results.add(nums[pos]);
    backtrack(pos + 1, nums, results);
    results.remove(results.size() - 1); // backtrack

    // Don't take current element
    backtrack(nextPos + 1, nums, results);
  }

}
