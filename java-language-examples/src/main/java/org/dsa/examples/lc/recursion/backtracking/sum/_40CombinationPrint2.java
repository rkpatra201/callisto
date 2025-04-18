package org.dsa.examples.lc.recursion.backtracking.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Unique Combination
// https://leetcode.com/problems/combination-sum-ii/submissions/1574179522/
public class _40CombinationPrint2 {
  public List<List<Integer>> combinationSum2(int[] inputs, int target) {

    List<List<Integer>> solutionSet = new ArrayList<>();

    List<Integer> currentValues = new ArrayList<>();
    Arrays.sort(inputs);
    solution1(target, inputs, solutionSet, currentValues, 0);

    return solutionSet;

  }


  private void solution1(int target,
                         int[] inputs,
                         List<List<Integer>> solutions,
                         List<Integer> currentValues,
                         int position) {


    if (target == 0) {
      System.out.println(currentValues);
      solutions.add(new ArrayList<>(currentValues));
      return;
    }

    if (target < 0) {
      return;
    }


    for (int index = position; index < inputs.length; index++) {

      if (index > position && inputs[index] == inputs[index - 1]) {
        continue;
      }
      int item = inputs[index];
      int rem = target - item;

      currentValues.add(item);
      solution1(rem, inputs, solutions, currentValues, index + 1);
      currentValues.remove(currentValues.size() - 1);

    }
  }
}
