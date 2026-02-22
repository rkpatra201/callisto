package org.dsa.examples.v1.dp.sum;

public class TargetSumExists_Recursion {

  public boolean solution(int t, int[] arr) {
    if (t == 0) return true;
    if (t < 0) return false;

    for(int item: arr){
      int rem = t - item;
      boolean result = solution(rem, arr);
      if(result){
        return true;
      }
    }
    return false;
  }
}
