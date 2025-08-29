package org.dsa.examples.v1.dp.grid;

public class GridPathMaxSumRecursion1 extends GridPathMaxSumRecursion {

  /**
   * right and down move allowed
   *
   * @param arr
   * @param i
   * @param j
   * @param m
   * @param n
   * @return
   */
  public int solution(int[][] arr, int i, int j, int m, int n) {

    solutionRecursive(arr, i, j, m, n, 0);

    return maxSum;

  }

  private static int maxSum = Integer.MIN_VALUE;
  public void solutionRecursive(int[][] arr, int i, int j, int m, int n, int sum) {


    if (i == m && j == n) {
     maxSum = Math.max(maxSum, sum + arr[i][j]);
    }
    if (i > m || j > n) {
      return;
    }
    int currentSum = arr[i][j];
    solutionRecursive(arr, i+1, j, m, n, sum + currentSum);
    solutionRecursive(arr, i, j+1, m, n, sum + currentSum);

  }
}
