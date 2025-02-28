package org.dsa.examples.arrays;

public class MajorityElement {

  public int solution(int[] arr){
    int candidate = -1;
    int count = 0;
    for(int num: arr){
      if(count == 0){
        candidate = num;
      }
      count = count + ((candidate == num) ? 1: -1);
    }
    return candidate;
  }
}
