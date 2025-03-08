package org.dsa.examples.dp;

import org.dsa.examples.dp.sum.HowTargetSum_Memo;
import org.dsa.examples.dp.sum.HowTargetSum_Recursion;
import org.dsa.examples.dp.sum.HowTargetSum_Recursion_UseOnce;
import org.dsa.examples.dp.sum.HowTargetSum_Tabulation;
import org.dsa.examples.dp.sum.Shortest_HowTargetSum_Recursion;
import org.dsa.examples.dp.sum.Shortest_HowTargetSum_Tabulation;
import org.dsa.examples.dp.sum.TargetSumExists_Memo;
import org.dsa.examples.dp.sum.TargetSumExists_Recursion;
import org.dsa.examples.dp.sum.TargetSumExists_Tabulation;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TargetSumAllApproachesTest {

  /**
   *  use each item of inputs only once
   */
  @Test
  public void combination_TargetSum_UseOnce() {
    int[] arr = {2, 3, 4};
    int target = 7;
    //RECURSION: find one of the combination for targetsum
    HowTargetSum_Recursion_UseOnce recursion = new HowTargetSum_Recursion_UseOnce();
    List<List<Integer>> list = null; //recursion.solution(target, arr);

    arr = new int[]{1,1,2,5,6,7,10};
    target = 8;
    recursion = new HowTargetSum_Recursion_UseOnce();
    list = recursion.solution(target, arr);
    System.out.println(list);

  }
  /**
   * 2. return the combination [] for target sum
   */
  @Test
  public void combination_TargetSum() {
    int[] arr = {2, 3, 4};
    int target = 7;
    //RECURSION: find one of the combination for targetsum
    HowTargetSum_Recursion recursion = new HowTargetSum_Recursion();
    int[] result = recursion.solution(target, arr);
    System.out.println(Arrays.toString(result));

    //MEMO: find one of the combination for targetsum
    HowTargetSum_Memo memo = new HowTargetSum_Memo();
    Integer[] resultMemo = memo.solution(target, arr);
    System.out.println(Arrays.toString(resultMemo));

    //TABULATION: find one of the combination for targetsum
    HowTargetSum_Tabulation tabulation = new HowTargetSum_Tabulation();
    int[] resultTab = tabulation.solution(target, arr);
    System.out.println(Arrays.toString(resultTab));
  }

  @Test
  public void shortestLengthCombinationForTargetSum(){

    int[] arr = {2, 3, 4};
    int target = 7;

    //TABULATION: find one of the shortest combination for targetsum
    Shortest_HowTargetSum_Tabulation shortest_howTargetSum_tabulation = new Shortest_HowTargetSum_Tabulation();
    int[] result1 = shortest_howTargetSum_tabulation.solution(target, arr);
    System.out.println(Arrays.toString(result1));

    //RECURSION: find one of the shortest combination for targetsum
    Shortest_HowTargetSum_Recursion recursion = new Shortest_HowTargetSum_Recursion();
    int[] result2 = recursion.solution(target, arr);
    System.out.println(Arrays.toString(result2));


  }
  /**
   * 1. target sum exists
   */
  @Test
  public void targetSumExists()
  {
    int[] arr = {2, 3, 4};
    int target = 7;

    //RECURSION: targetSum exists
    TargetSumExists_Recursion targetSumExists_recursion = new TargetSumExists_Recursion();
    boolean flag = targetSumExists_recursion.solution(target, arr);
    System.out.println(flag);

    //MEMO: targetSum exists
    TargetSumExists_Memo memo = new TargetSumExists_Memo();
    flag = memo.solution(target, arr);
    System.out.println(flag);

    //TABULATION: targetSum exists
    TargetSumExists_Tabulation tabulation = new TargetSumExists_Tabulation();
    flag = tabulation.solution(target, arr);
    System.out.println(flag);
  }
}