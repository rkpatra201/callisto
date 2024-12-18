package org.dsa.examples.dp.sum;

import java.util.Arrays;

public class TargetSumExists_Memo {

  private int[] memo = null;

  public boolean solution(int t, int[] arr) {

    if (memo == null) {
      memo = new int[t + 1];
      Arrays.fill(memo, -1);
    }

    if (t < 0) return false;
    if(memo[t]!=-1) return memo[t] == 1;
    if (t == 0) return true;

    for (int item : arr) {
      int rem = t - item;
      boolean result = solution(rem, arr);
      if (result) {
        memo[t] = 1;
        return true;
      }
    }
    memo[t] = 0;
    return false;
  }
}
