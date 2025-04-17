package org.dsa.examples.lc.dp.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40CombinationSum2 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates); // Required to handle duplicates
    backtrack(candidates, 0, target, new ArrayList<>(), result);
    return result;
  }

  private void backtrack(int[] arr, int index, int target, List<Integer> current, List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(current));
      return;
    }
    if (index == arr.length) {
      return;
    }

    // NOT TAKE the current index
    int nextIndex = index + 1;
    // Skip duplicates
    while (nextIndex < arr.length && arr[nextIndex] == arr[index]) {
      nextIndex++;
    }
    backtrack(arr, nextIndex, target, current, result);

    // TAKE the current index (only if it's not greater than target)
    if (arr[index] <= target) {
      current.add(arr[index]);
      backtrack(arr, index + 1, target - arr[index], current, result);
      current.remove(current.size() - 1); // backtrack
    }
  }
}
