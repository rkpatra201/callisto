package org.dsa.examples.lc.dp.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

// https://leetcode.com/problems/combination-sum-iii/submissions/1574176641/
public class _216CombinationPrint3 {
  public List<List<Integer>> combinationSum3(int k, int n) {

    int[] inputs = IntStream.range(1, 10).toArray();
    solution(inputs, k, n, new ArrayList<>(), 0);
    return result;
  }


  private Map<Integer, Boolean> visited = new HashMap<>();
  private List<List<Integer>> result = new ArrayList<>();

  public void solution(int[] inputs, int depth, int target, List<Integer> current, int pos) {
    if (depth == 0 && target == 0) {
      System.out.println(current);
      result.add(new ArrayList<>(current));
    }

    if (target < 0) {
      return;
    }

    for (int i = pos; i < inputs.length; i++) {
      int item = inputs[i];


      current.add(item);
      solution(inputs, depth - 1, target - item, current, i + 1);
      current.remove(current.size() - 1);

    }
  }
}
