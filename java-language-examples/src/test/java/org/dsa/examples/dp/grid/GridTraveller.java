package org.dsa.examples.dp.grid;

import org.junit.Assert;
import org.junit.Test;

public class GridTraveller {

  @Test
  public void gridPathCountRecursion() {
    int[][] arr = {{1,2}, {3, 4}};
    int expectedResult = 2;
    int result = new GridPathCountWays().solution(arr,2, 2);
    System.out.println(result);
    Assert.assertEquals(expectedResult, result);

    result = new GridPathCountWaysTabulation().solution(arr, 2, 2);
    System.out.println(result);
    Assert.assertEquals(expectedResult, result);
  }


  @Test
  public void gridPathMaxSumRecursion() {
    int[][] arr = {{1,2}, {3, 4}};
    int result = new GridPathMaxSumRecursion().solution(arr, 0, 0, 2, 2);
    System.out.println(result);
    Assert.assertEquals(8, result);

    result = new GridPathMaxSumRecursion1().solution(arr, 0,0,1,1);
    System.out.println(result);
    Assert.assertEquals(8, result);
  }

  @Test
  public void gridPathMaxSumMemo() {
    int[][] arr = {{1,0, 2}, {3, 0, 4}, {5, 0, 1}};
    int result = new GridPathMaxSumMemo().solution(arr, 0, 0, 3, 3);
    System.out.println(result);
  }

  @Test
  public void gridPathMaxSumTabulation() {
    int[][] arr = {
        {1,2},
        {-3,10},
        {5,1}
    };
    int result = new GridPathMaxSumTabulation().solution(arr, 3, 2);
    System.out.println(result);
    Assert.assertEquals(14, result);

    result = new GridPathMaxSumTabulation().solution1(arr, 3, 2);
    System.out.println(result);
    Assert.assertEquals(14, result);
  }
}