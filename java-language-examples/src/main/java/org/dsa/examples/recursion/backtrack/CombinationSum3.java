package org.dsa.examples.recursion.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

// https://leetcode.com/problems/combination-sum-iii/submissions/
public class CombinationSum3 {

  public static void main(String[] args) {
    CombinationSum3 fx = new CombinationSum3();
    int k = 3;
    int n = 9;
    int[] inputs = IntStream.range(1, 10).toArray();
    fx.solution(inputs, k, n, new ArrayList<>(), 0);
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
