package org.dsa.examples.v1.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// this is to find unique combination that sum to a target.
// but each element used once
// https://leetcode.com/problems/combination-sum-ii/
// https://leetcode.com/problems/combination-sum-ii/submissions/1571112186/
public class CombinationSum2 {

  public List<List<Integer>> solution(int target, int[] inputs) {
    List<List<Integer>> solutionSet = new ArrayList<>();
    List<Integer> currentValues = new ArrayList<>();
    Arrays.sort(inputs);
    solution1(target, inputs, solutionSet, currentValues, 0);
    System.out.println(solutionSet);

    return solutionSet;
  }

  /**
   * The condition:
   *
   * ```java
   * if(index > position && inputs[index] == inputs[index-1]){
   *     continue;
   * }
   * ```
   * is used to **skip duplicate elements** in the sorted input array to avoid generating duplicate combinations.
   *
   * ### **Why is this needed?**
   * When the input contains duplicate numbers, without this check, the function might generate the same combination multiple times.
   *
   * For example, consider:
   * ```java
   * int[] inputs = {1, 1, 2, 5};
   * int target = 3;
   * ```
   *
   * Without the condition, both `1` at index `0` and `1` at index `1` would be used separately in different branches of recursion, leading to duplicate results.
   *
   * ### **How does it work?**
   * 1. **Sorting first**: The array is sorted to group duplicates together.
   * 2. **Skipping duplicates**: If `inputs[index] == inputs[index - 1]`, and we are not at the first occurrence of the number in this iteration (`index > position`), we **skip** this duplicate number.
   *
   * ### **Example**
   * #### **Input:**
   * ```java
   * int[] inputs = {1, 1, 2, 5};
   * int target = 3;
   * ```
   * #### **Sorted Array:**
   * ```
   * [1, 1, 2, 5]
   * ```
   * #### **Without Skipping Duplicates**
   * We might generate:
   * ```
   * [1, 2]
   * [1, 2]  // Duplicate
   * ```
   *
   * #### **With the Condition**
   * - When `index == 1`, `inputs[1] == inputs[0]`, so we skip `index = 1` to avoid duplicate sets.
   *
   * Thus, only one `[1, 2]` will be generated.
   *
   * ### **Key Takeaway**
   * This condition **ensures unique combinations by skipping duplicate numbers** in the same recursive call level.
   *
   * 🚀 **Best Practice:** Always **sort** the input and use this check when dealing with duplicate elements in backtracking problems to avoid redundant solutions.
   */
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


    // as it is a use once problem, so we are not starting index as 0.
    // each time our index starts from a incremented position to reduce the inputs
    for (int index = position; index < inputs.length; index++) {

      if(index > position && inputs[index] == inputs[index-1]){
        continue;
      }
      int item = inputs[index];
      int rem = target - item;

      currentValues.add(item);
      solution1(rem, inputs, solutions, currentValues, index+1); // each number use at most once. we are making sure we will not choose the already selected element
      currentValues.remove(currentValues.size() - 1);
    }
  }
}
