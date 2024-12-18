package org.dsa.examples.arrays;

public class MaxProductSubArray {

  public int solution(int[] input) {

    if(input.length == 0)
      return 0;

    int result = input[0];

    int currentMax =1, currentMin = 1;

    for (int num : input) {

      if (num == 0) {
        currentMin = 1;
        currentMax = 1;
        continue;
      }

      int x_min = findMin(num * currentMax, num * currentMin, num);
      int x_max = findMax(num * currentMax, num * currentMin, num);
      result =findMax(result, x_min, x_max);
      currentMin = x_min;
      currentMax = x_max;
    }

    return result;
  }

  private static int findMax(int x, int y, int z){
    int r = Math.max(x,y);
    return Math.max(r,z);
  }


  private static int findMin(int x, int y, int z){
    int r = Math.min(x,y);
    return Math.min(r,z);
  }
}
