package org.dsa.examples.dp.sum;

import java.util.Arrays;

public class Shortest_HowTargetSum_Tabulation {

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
        if (index >= tab.length) continue;
        int[] prev = tab[index];
        int[] current = AppUtils.merge(target, tab[i], new int[]{num});
        int currentLength = AppUtils.countLength(current);
        int prevLength =  AppUtils.countLength(prev);
        if (prev == null || currentLength < prevLength) {
          tab[index] = current;
        }
      }
    }
    return tab[target];
  }
}
