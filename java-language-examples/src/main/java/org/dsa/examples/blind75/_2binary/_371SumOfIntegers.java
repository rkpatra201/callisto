package org.dsa.examples.blind75._2binary;

// https://leetcode.com/problems/sum-of-two-integers/submissions/1591562330/
public class _371SumOfIntegers {

  // a: swoc: sum without carry: use xor
  // b: swc: sum with carry: use & then apply left shift
  // recurse until b is 0 and return a
  public int getSum(int a, int b) {

    if(b == 0){
      return a;
    }
    // sum without carry
    int swoc = a ^ b;

    // sum with carry
    int and = a & b; // and
    int swc = and << 1; // left shift

    return getSum(swoc,swc);

  }
}
