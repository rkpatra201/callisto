package org.dsa.examples.v1.arrays;

public class NthRoot {

  public static void main(String[] args) {
    int result = solution(8);
    System.out.println(result);
  }

  public static int solution(int n){
      int start = 0;
      int end = n;
      while (start <= end) {
          int mid = start + (end - start) / 2;
          long square = (long) mid * mid;
          if (square == n) {
              return mid;
          } else if (square < n) {
              start = mid + 1;
          } else {
              end = mid - 1;
          }
      }
      return end;
      /**
       * We return end because,
       * after the binary search loop,
       * end will be the largest integer whose square is less than or equal to n. If n is not a perfect square,
       * the loop exits when start surpasses end,
       * and end holds the closest integer root.
       * This ensures the function returns the integer part of the square root.
       */
  }
}
