package org.dsa.examples.lc.dp.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/submissions/1594103980/
public class _39CombinationSum1 {
  public List<List<Integer>> combinationSum(int[] inputs, int target) {
    List<List<Integer>> solutionSet = new ArrayList<>();
    List<Integer> currentValues = new ArrayList<>();
    Arrays.sort(inputs);
    solution(target, inputs, solutionSet, currentValues, 0);
    return solutionSet;
  }

  private void solution(int target,
                        int[] inputs,
                        List<List<Integer>> solutions,
                        List<Integer> currentValues,
                        int position) {
    if (target == 0) {
      solutions.add(new ArrayList<>(currentValues));
      return;
    }

    if (target < 0) {
      return;
    }

    if (position > inputs.length - 1 || inputs[position] > target) {
      return;
    }


    int item = inputs[position];
    int rem = target - item;

    solution(target, inputs, solutions, currentValues, position + 1);

    currentValues.add(item);
    solution(rem, inputs, solutions, currentValues, position); // position not incremented as we allow repeat usage
    currentValues.remove(currentValues.size() - 1);

  }
}
