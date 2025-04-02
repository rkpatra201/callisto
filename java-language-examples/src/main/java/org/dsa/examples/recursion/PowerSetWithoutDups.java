package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/submissions/1593822024/
public class PowerSetWithoutDups {
  public List<List<Integer>> subsetsWithDup(int[] nums) {

    Arrays.sort(nums);
    recurse(0, nums, new ArrayList<>());

    return all;
  }

  List<List<Integer>> all = new ArrayList<>();

  private void recurse(int pos, int[] nums, List<Integer> results) {

    if (pos > nums.length - 1) {
      System.out.println(results);
      all.add(results);
      return;
    }

    List<Integer> include = new ArrayList<>(results);
    List<Integer> exclude = new ArrayList<>(results);
    //include.addAll(new ArrayList<>(results));

    include.add(nums[pos]);
    recurse(pos + 1, nums, include);

    while (pos < nums.length - 1 && nums[pos + 1] == nums[pos]) {
      pos++;
    }

    // exclude.addAll(new ArrayList<>(results));
    recurse(pos + 1, nums, exclude);
  }
}
