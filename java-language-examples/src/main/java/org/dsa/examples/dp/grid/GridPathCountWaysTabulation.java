package org.dsa.examples.dp.grid;

public class GridPathCountWaysTabulation {

  private int[][] tab = null;
  public int solution(int[][] arr, int m , int n){
    for(int i=0; i< m ; i++){
      for(int j = 0; j < n; j++){

        if(tab == null) {
          tab = new int[m][n];
          tab[i][j] = 1;
          continue;
        }

        int down = i==0? 0: tab[i-1][j];
        int right = j ==0? 0: tab[i][j-1];
        tab[i][j] = down + right;
      }

    }
    return tab[m-1][n-1];
  }
}
