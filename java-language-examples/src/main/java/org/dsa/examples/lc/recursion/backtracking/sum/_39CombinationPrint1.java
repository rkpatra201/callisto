package org.dsa.examples.lc.recursion.backtracking.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/submissions/1594103980/
public class _39CombinationPrint1 {
  public List<List<Integer>> combinationSum(int[] inputs, int target) {
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
      solutions.add(new ArrayList<>(currentValues));
      return;
    }

    if (target < 0) {
      return;
    }

    for (int i = position; i < inputs.length; i++) {
      currentValues.add(inputs[i]);
      // we wont increase i value in below recursion branch. because re-use is allowed
      solution1(target - inputs[i], inputs, solutions, currentValues, i);
      currentValues.remove(currentValues.size() - 1);
    }
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

    List<Integer> include = new ArrayList<>(currentValues);

    include.add(item);
    solution(rem, inputs, solutions, include, position); // position not incremented as we allow repeat usage

    List<Integer> exclude = new ArrayList<>(currentValues);
    solution(target, inputs, solutions, exclude, position + 1);

  }
}
