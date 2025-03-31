package org.dsa.examples.blind75._2binary;

// https://leetcode.com/problems/counting-bits/submissions/1591570589/
public class _338CountingBits {
  public int[] countBits(int n) {
    int[] result = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      result[i] = hammingWeight(i);
    }

    return result;
  }

  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n - 1); // removes right most 1
      count++;
    }
    return count;
  }
}
