package org.dsa.examples.dp.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowTargetSum_Recursion_UseOnce {

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

    // to avoid duplicate constructs like(1,2,5) or (5,2,1) both construct to 8
    if (position > 0 && inputs[position] == inputs[position - 1]) {
      return;
    }

    // as it is a use once problem, so we are not starting index as 0.
    // each time our index starts from a incremented position to reduce the inputs
    for (int index = position; index < inputs.length; index++) {
      int item = inputs[index];
      int rem = target - item;
      /**
       *  clone is required because with each iteration of this loop,
       *  it will append elements to the #currentValues, which is invalid
       */
      List<Integer> copyValues = new ArrayList<>(currentValues);
      copyValues.add(item);
      solution(rem, inputs, solutions, copyValues, index + 1);
    }
  }
}
