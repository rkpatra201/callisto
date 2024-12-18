package org.dsa.examples.dp.sum;

public class Shortest_HowTargetSum_Recursion {

  public int[] solution(int target, int[] inputs) {
     if(target == 0) return new int[0];
     if(target < 0) return null;

     int[] shortestCombination = null;
     for(int item: inputs){
       int rem = target - item;
       int[] result = solution(rem, inputs);
       if(result!=null){
         int[] current = AppUtils.merge(target, result, new int[]{item});
         int currentLen = AppUtils.countLength(current);
         int prevLen = AppUtils.countLength(shortestCombination);
         if(shortestCombination == null || currentLen < prevLen){
           shortestCombination = current;
         }
       }
     }
     return shortestCombination;
  }

  public int[] merge(int length, int[] arr1, int[] arr2) {
    int[] arr = new int[length + 1];
    int i = 0;
    for (int item : arr1) {
      if (item == 0)
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
