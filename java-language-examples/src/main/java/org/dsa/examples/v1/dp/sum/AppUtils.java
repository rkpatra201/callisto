package org.dsa.examples.v1.dp.sum;

public class AppUtils {
  /**
   * Recursion
   * Memo
   * Tabulation
   */


  public static int countLength(int[] arr) {
    if (arr == null) {
      return 0;
    }
    int count = 0;
    for (int i : arr) {
      if (i != 0) {
        count++;
      }
    }
    return count;
  }

  public static int countLength(Integer[] arr) {
    int count = 0;
    for (Integer i : arr) {
      if (i != null && i != 0) {
        count++;
      }
    }
    return count;
  }

  public static int[] merge(int target, int[] source, int[] contribution) {
    int[] destination = new int[target + 1];
    int i = 0;
    for (int item : source) {
      if (item == 0)
        continue;
      destination[i] = item;
      i++;
    }

    for (int item : contribution) {
      if (item == 0)
        continue;
      destination[i] = item;
      i++;
    }
    return destination;
  }

  public static int max(int... arr) {
    int max = arr[0];
    for (int i : arr) {
      max = Math.max(i, max);
    }
    return max;
  }

  public static int min(int... arr) {
    int min = arr[0];
    for (int i : arr) {
      min = Math.min(i, min);
    }
    return min;
  }

  public static String findLongestStr(String... args){
    String result = args[0];
    for(String input:args){
      if(input.length() > result.length()){
        result = input;
      }
    }
    return result;
  }

}
