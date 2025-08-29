package org.dsa.examples.blind75._2binary;

// https://leetcode.com/problems/number-of-1-bits/submissions/1591565828/
public class _191CountSetBits {
  public int hammingWeight(int n) {
    int count = 0;
    while(n!=0){
      n = n & (n - 1); // removes right most 1
      count++;
    }
    return count;
  }
}
