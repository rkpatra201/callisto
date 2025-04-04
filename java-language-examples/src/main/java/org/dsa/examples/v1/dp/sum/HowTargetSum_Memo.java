package org.dsa.examples.v1.dp.sum;

import java.util.Arrays;

public class HowTargetSum_Memo {

  private Integer[][] memo = null;
  public Integer[] solution(int target, int[] inputs) {
    if(memo == null){
      memo = new Integer[target + 1][];
      Arrays.fill(memo, null);
    }
    if(target < 0) return null;
    if(memo[target]!=null) return memo[target];
     if(target == 0) return new Integer[0];

     for(int item: inputs){
       int rem = target - item;
       Integer[] result = solution(rem, inputs);
       if(result!=null){
         Integer[] mergedResult = merge(target, result, new int[]{item});
         memo[target] = mergedResult;
         return mergedResult;
       }
     }
     memo[target]=null;
     return null;
  }

  public Integer[] merge(int length, Integer[] arr1, int[] arr2) {
    Integer[] arr = new Integer[length + 1];
    int i = 0;
    for (Integer item : arr1) {
      if (item == null || item == 0)
        continue;
      arr[i] = item;
      i++;
    }

    for (int item : arr2) {
      if (item == 0)
        continue;
      arr[i] = item;
      i++;
    }
    return arr;
  }
}
