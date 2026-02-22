package org.dsa.examples.v1.dp.sum;

import java.util.Arrays;

public class TargetSumExists_Tabulation {

  public boolean solution(int t, int[] arr) {
    boolean[] tab = new boolean[t+1];
    Arrays.fill(tab, false);
    tab[0] = true;
    for(int i = 0; i< t; i++){
      if(tab[i] == true){
        for(int item: arr){
          int tabIndex = i + item;
          if(tabIndex > t) {
            continue;
          }
          tab[tabIndex] = true;
        }
      }
    }
    return tab[t];
  }
}
