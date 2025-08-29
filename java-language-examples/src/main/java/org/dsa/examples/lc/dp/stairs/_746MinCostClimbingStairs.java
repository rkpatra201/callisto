package org.dsa.examples.lc.dp.stairs;

import java.util.Arrays;

public class _746MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    initMemo(cost.length);
    return Math.min(dfs(0, cost), dfs(1, cost));
  }

  private void initMemo(int n){
    memo = new int[n];
    Arrays.fill(memo, -1);
  }

  private int[] memo = null;
  private int dfs(int index, int[] cost){

    if(index >= cost.length){ // invalid index
      return 0;
    }
    if(memo[index]!=-1){
      return memo[index];
    }
    int oneStep = dfs(index + 1, cost);
    int twoStep = dfs(index + 2, cost);

    memo[index] = cost[index] + Math.min(oneStep, twoStep);
    return memo[index];

  }
}
