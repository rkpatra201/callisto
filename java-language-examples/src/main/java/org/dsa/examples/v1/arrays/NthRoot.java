package org.dsa.examples.v1.arrays;

public class NthRoot {

  public static void main(String[] args) {
    int result = solution(100, 0, 15);
    System.out.println(result);
  }

  public static int solution(int num, int low, int high){
    if(low > high){
      return -1;
    }

    int m = (low + high)/2;
    if(m*m == num) return m;
    if(m*m < num) return solution(num, m+1, high);
    if(m*m > num) return solution(num, low, m -1);

    return -1;
  }
}
