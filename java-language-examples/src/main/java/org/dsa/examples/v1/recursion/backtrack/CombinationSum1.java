package org.dsa.examples.v1.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// this is to find unique combination that sum to a target.
// but each element used multiple times
// https://leetcode.com/problems/combination-sum/submissions/1571003161/
public class CombinationSum1 {

  public List<List<Integer>> solution(int target, int[] inputs) {
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

    List<Integer> copyValues = new ArrayList<>(currentValues);

    copyValues.add(item);
    solution(rem, inputs, solutions, copyValues, position);
    copyValues.remove(copyValues.size() - 1);

    solution(target, inputs, solutions, copyValues, position + 1);

  }
}

