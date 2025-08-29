package org.dsa.examples.v1.dp.grid;

public class GridPathCountWays {

  public int solution(int[][] arr, int i , int j){ // i*j matrix dimension
    if(i == 1 && j == 1) return 1; // when it is 1*1 matrix, only one way is present
    if( i <= 0 || j <= 0) return 0;
    int down = solution(arr,i-1 , j);
    int right = solution(arr, i , j-1);
    return down + right;
  }
}
