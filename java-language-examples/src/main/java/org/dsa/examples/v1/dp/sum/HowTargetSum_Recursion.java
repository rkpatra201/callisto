package org.dsa.examples.v1.dp.sum;

public class HowTargetSum_Recursion {

  public int[] solution(int target, int[] inputs) {
     if(target == 0) return new int[0];
     if(target < 0) return null;

     int[] bestResult = null;
     for(int item: inputs){
       int rem = target - item;
       int[] result = solution(rem, inputs);
       if(result!=null){
         int[] mergedResult = merge(target, result, new int[]{item});
         bestResult = mergedResult;
         return bestResult;
       }
     }
     return bestResult;
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
