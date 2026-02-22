package org.dsa.examples.v1.recursion;

import java.util.ArrayList;
import java.util.List;

public class _78PowerSet {

  public void solution(int[] arr) {

    List<List<Integer>> solutions = new ArrayList<>();

    solution(arr, 0, new ArrayList<>(), solutions);

    System.out.println(solutions);

  }

  /**
   * [1,2,3]
   *                                       []
   *                           [1]          |          []         index=0
   *                    [1,2]         [1]   |    [2]       []     index=1
   *              [1,2,3] [1,2] | [1,3] [1] | [2,3] [2] | [3] []  index=2
   *
   * @param arr
   * @param index
   * @param current
   * @param solutions
   */

  private void solution(int[] arr, int index,
                        List<Integer> current,
                        List<List<Integer>> solutions){
    if(index == arr.length){ // that means leaf node arrived in recursion tree
      solutions.add(new ArrayList<>(current));
      return;
    }
    List<Integer> inclusion = new ArrayList<>(current);// inclusion
    inclusion.add(arr[index]);
    solution(arr, index + 1, inclusion, solutions);

    List<Integer> exclusion = new ArrayList<>(current);// inclusion
    solution(arr, index+1, exclusion, solutions);
  }
}
