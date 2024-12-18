package org.dsa.examples.dp.sum;

import java.util.Arrays;

public class HowTargetSum_Tabulation {

  public int[] solution(int target, int[] inputs) {
    int[][] tab = new int[target + 1][];
    Arrays.fill(tab, null);
    tab[0] = new int[target + 1];

    for (int i = 0; i < tab.length; i++) {
      if (tab[i] == null) {
        continue;
      }
      for (int num : inputs) {
        int index = i + num;
        if(index >= tab.length) continue;
        tab[index] = merge(target, tab[i], new int[]{num});
      }
    }
    return tab[target];
  }

  public int[] merge(int target, int[] arr1, int[] arr2) {
    int[] arr = new int[target + 1];
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
