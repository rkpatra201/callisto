package org.dsa.examples.dp.grid;

public class GridPathMaxSumRecursion {

  public int solution(int[][] arr, int i, int j, int m, int n){
    if(i == m && j == n) return arr[i-1][j-1];
    if( i >= m || j >= n) return 0;
    int down = solution(arr, i+1, j, m, n);
    int right = solution(arr, i, j+1, m, n);
    int result = arr[i][j]  +  Math.max(down, right);
    return result;
  }
}
