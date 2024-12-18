package org.dsa.examples.dp.grid;

public class GridPathMaxSumMemo {

  private int[][] tab = null;
  public int solution(int[][] arr, int i, int j, int m, int n){
    if(tab == null){
      tab = new int[m][n];
    }
    if( i >= m || j >= n) return 0;
    if(tab[i][j] !=0) return tab[i][j];
    int down = solution(arr, i+1, j, m, n);
    int right = solution(arr, i, j+1, m, n);
    int result = arr[i][j]  +  Math.max(down, right);
    tab[i][j] = result;
    return result;
  }
}
