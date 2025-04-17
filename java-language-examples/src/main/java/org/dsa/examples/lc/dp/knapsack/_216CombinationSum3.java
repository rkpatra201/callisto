package org.dsa.examples.lc.dp.knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class _216CombinationSum3 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    int[] inputs = IntStream.range(1, 10).toArray(); // numbers 1 to 9
    backtrack(inputs, 0, k, n, new ArrayList<>(), result);
    return result;
  }

  private void backtrack(int[] nums, int index, int k, int target, List<Integer> current, List<List<Integer>> result) {
    if (k == 0 && target == 0) {
      result.add(new ArrayList<>(current));
      return;
    }

    if (index == nums.length || target < 0 || k < 0) {
      return;
    }

    // NOT TAKE the current number
    backtrack(nums, index + 1, k, target, current, result);

    // TAKE the current number
    current.add(nums[index]);
    backtrack(nums, index + 1, k - 1, target - nums[index], current, result);
    current.remove(current.size() - 1); // backtrack
  }
}
